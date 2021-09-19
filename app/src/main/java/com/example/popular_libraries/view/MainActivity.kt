package com.example.popular_libraries.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.popular_libraries.databinding.ActivityMainBinding
import com.example.popular_libraries.presenter.MainPresenter
import com.example.popular_libraries.utils.Numbers

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButtonClickListener()
    }

    private fun setButtonClickListener() {
        binding.buttonCounter1.setOnClickListener {
            presenter.counterClick(Numbers.ONE)
        }
        binding.buttonCounter2.setOnClickListener {
            presenter.counterClick(Numbers.TWO)
        }
        binding.buttonCounter3.setOnClickListener {
            presenter.counterClick(Numbers.THREE)
        }
    }

    override fun setButton1Text(text: String) {
        binding.buttonCounter1.text = text
    }

    override fun setButton2Text(text: String) {
        binding.buttonCounter2.text = text
    }

    override fun setButton3Text(text: String) {
        binding.buttonCounter3.text = text
    }

}