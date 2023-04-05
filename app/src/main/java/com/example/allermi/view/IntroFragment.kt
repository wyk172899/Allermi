package com.example.allermi.view

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.animation.doOnRepeat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.allermi.R
import com.example.allermi.databinding.FragmentIntroBinding
import com.example.allermi.viewmodel.IntroViewModel
import kotlinx.coroutines.delay

class IntroFragment : Fragment() {
    private lateinit var binding: FragmentIntroBinding
    private val viewModel: IntroViewModel by lazy { ViewModelProvider(this).get(IntroViewModel::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_intro,container,false)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAnime(binding.animText)
    }


    override fun onResume() {
        super.onResume()
    }

    private fun initAnime2(view: View){

    }

    private fun initAnime(view: View) {
        val arr = arrayOf(" 모든", " 알레르기", " 환자를", " 위하여")
        var i = 0
//        val animation = AnimatorInflater.loadAnimator(requireContext(), R.animator.introanime).apply {
//            duration = 3000
//            interpolator = AccelerateDecelerateInterpolator()
//            doOnRepeat {
//                viewModel.addAnimString(arr[i])
//                Log.d("euya", i.toString())
//                i++
//            }
//        }
//        animation.setTarget(binding.animText)
//        animation.start()
        val animation = ObjectAnimator.ofFloat(view, View.SCALE_X, 0.5f, 1f).apply {
            duration = 500
            repeatMode = ValueAnimator.RESTART
            repeatCount = 4
            doOnRepeat {
                if(i<4){
                    viewModel.addAnimString(arr[i])
                    Log.d("euya", i.toString())
                }
                i++
            }
        }.start()

    }
}