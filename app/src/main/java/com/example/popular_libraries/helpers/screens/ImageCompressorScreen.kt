package com.example.popular_libraries.helpers.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.popular_libraries.convert.ImageCompressorFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ImageCompressorScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        ImageCompressorFragment.newInstance()
}