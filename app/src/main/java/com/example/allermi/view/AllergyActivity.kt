package com.example.allermi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.allermi.databinding.ActivityAllergyBinding
import com.google.android.material.chip.Chip

class AllergyActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAllergyBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        setContentView(binding.root)
        val allergyList = arrayOf(
            arrayOf("난류", "달걀", "계란", "메추리알"),
            arrayOf("육류", "소고기", "쇠고기", "돼지고기"),
            "닭고기",
            arrayOf("생선류", "고등어", "연어", "전어", "멸치", "명태", "참치", "삼치", "꽁치", "생선"),
            arrayOf("갑각류", "새우", "게", "가재"),
            arrayOf("연체동물류", "오징어", "조개", "가리비", "홍합", "굴"),
            arrayOf("유제품", "우유", "양유"),
            "견과류", "땅콩", "호두", "잣", "마카다미아", "헤이즐넛", "캐슈넛", "아몬드", "피스타치오",
            "대두", "콩",
            "과일", "복숭아", "사과", "자두", "키위",
            "토마토",
            "밀",
            "메밀",
            "아황산류"
        )

        for (index in allergyList) {

        }
    }

    fun addChip(txt: String, allergyId: Int) {
        val chip = Chip(this).apply {
            text = txt
            id = allergyId
            isCloseIconVisible = true

            setOnCloseIconClickListener {
                binding.chipGroup.removeView(this)
            }
        }
        binding.chipGroup.addView(chip)
    }




}