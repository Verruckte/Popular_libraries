package com.example.popular_libraries.presentation.users

import com.example.popular_libraries.presentation.GitHubUserViewModel
import com.example.popular_libraries.presentation.ScreenView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState

interface UsersView : ScreenView {

    @SingleState
    fun showUsers(users: List<GitHubUserViewModel>)
}