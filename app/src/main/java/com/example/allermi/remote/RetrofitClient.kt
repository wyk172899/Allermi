package com.example.allermi.remote

import com.example.allermi.util.Constants.DOWNLOAD_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitBuilder {
    private var instance: Retrofit? = null
    fun getInstance(): Retrofit {
        instance?.let {
            return it
        } ?: run {
            instance = Retrofit.Builder()
                .baseUrl(DOWNLOAD_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return instance!!
        }
    }
}

interface RetrofitService {
    @GET("")
    fun getData(): Call<String>
}