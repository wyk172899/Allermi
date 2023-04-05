package com.example.allermi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.allermi.R
import com.example.allermi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fragTrasact(IntroFragment())
    }
    private fun fragTrasact(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(binding.frame.id,fragment)
            .commit()
    }
}