package com.example.popular_libraries.view

import com.github.terrakok.cicerone.androidx.FragmentScreen


class UserScreen(private val login: String) {
    fun create() = FragmentScreen { UserFragment.newInstance(login) }
}