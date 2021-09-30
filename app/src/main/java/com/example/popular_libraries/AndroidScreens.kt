package com.example.popular_libraries

import com.example.popular_libraries.model.GithubUser
import com.example.popular_libraries.presenter.IScreens
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = UsersScreen()
    override fun user(user: GithubUser) = UserScreen(user)
}
