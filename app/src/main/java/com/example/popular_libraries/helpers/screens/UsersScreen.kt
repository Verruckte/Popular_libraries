package com.example.popular_libraries.helpers.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.popular_libraries.baselogic.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment = UsersFragment.newInstance()
}