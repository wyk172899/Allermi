package com.example.allermi.view

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.allermi.R
import com.example.allermi.databinding.ActivityIntroBinding
import com.example.allermi.viewmodel.IntroViewModel

class IntroActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityIntroBinding.inflate(layoutInflater)
    }
    private val viewModel: IntroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        setContentView(binding.root)
        initAnime()
    }


    private fun animeSeperation(pair: Pair<Int, View>): AnimatorSet {
        return (AnimatorInflater.loadAnimator(
            this,
            pair.first
        ) as AnimatorSet).apply {
            setTarget(pair.second)
            if (pair.second == binding.titleText) {
                pair.second.pivotX = 800f
            } else {
                pair.second.pivotX = 200f
            }
            start()
        }
    }

    private fun initAnime() {
        val animString = arrayListOf(
            Pair(R.animator.introanime_title, binding.titleText),
            Pair(R.animator.introanime_text1, binding.animText1),
            Pair(R.animator.introanime_text2, binding.animText2),
            Pair(R.animator.introanime_text3, binding.animText3),
            Pair(R.animator.introanime_text4, binding.animText4),
            Pair(R.animator.introanime_text5, binding.animText5),
        )

        AnimatorSet().apply {
            play(animeSeperation(animString[0])).with(animeSeperation(animString[1]))
            play(animeSeperation(animString[0])).with(animeSeperation(animString[2]))
            play(animeSeperation(animString[0])).with(animeSeperation(animString[3]))
            play(animeSeperation(animString[0])).with(animeSeperation(animString[4]))
            play(animeSeperation(animString[0])).with(animeSeperation(animString[5]))
            start()
        }
    }
}