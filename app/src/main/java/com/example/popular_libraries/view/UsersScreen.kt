package com.example.popular_libraries.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.popular_libraries.view.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object UsersScreen {
    fun create() = FragmentScreen { UsersFragment.newInstance() }
}