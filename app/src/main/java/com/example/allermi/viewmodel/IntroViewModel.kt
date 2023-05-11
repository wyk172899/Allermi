package com.example.allermi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allermi.remote.RetrofitBuilder
import com.example.allermi.remote.RetrofitService
import com.example.allermi.util.AllergyConverter
import com.example.allermi.util.Constants.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Callback
import retrofit2.Call
import org.jsoup.HttpStatusException
import org.jsoup.Jsoup
import retrofit2.Response
import java.lang.Exception

class IntroViewModel : ViewModel() {
    private val service = RetrofitBuilder.getInstance().create(RetrofitService::class.java)
    private var latestUpdatedDate = ""

    init {
        viewModelScope.launch {
            if (latestUpdatedDate.isBlank()) {
                latestUpdatedDate = getVersion().toString()
                downloadFile()
            } else if (getVersion().toString() != latestUpdatedDate) {
                downloadFile()
            }
        }
    }

    // 이미지 크롤링 하는 함수
    private fun getVersion() = viewModelScope.async(Dispatchers.IO) {
        kotlin.runCatching {
            Jsoup.connect(URL).get()
        }.onSuccess { doc ->
            doc.select("span.con").first().toString()
        }.onFailure {
            when (it) {
                is HttpStatusException -> it.printStackTrace()
                is Exception -> it.printStackTrace()
            }
        }
    }

    private fun downloadFile() = viewModelScope.launch(Dispatchers.IO) {
        service.getData().enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                AllergyConverter().allergyConvert(response.body()?.substring(0)!!.split("\n"))
            }

            override fun onFailure(call: Call<String>, t: Throwable) {

            }
        })
    }
}
