package com.example.popular_libraries.presentation.user

import com.example.popular_libraries.presentation.GitHubUserViewModel
import com.example.popular_libraries.presentation.ScreenView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : ScreenView {

    @SingleState
    fun showUser(user: GitHubUserViewModel)
}
