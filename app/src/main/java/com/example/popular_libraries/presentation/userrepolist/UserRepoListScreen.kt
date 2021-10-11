package com.example.popular_libraries.presentation.userrepolist

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UserRepoListScreen(private val reposUrl: String) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        UserRepoListFragment.newInstance(reposUrl)
}