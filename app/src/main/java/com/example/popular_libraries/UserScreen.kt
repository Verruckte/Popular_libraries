package com.example.popular_libraries

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.popular_libraries.model.GithubUser
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UserScreen(private val user: GithubUser) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
            UserFragment.newInstance(user)
}