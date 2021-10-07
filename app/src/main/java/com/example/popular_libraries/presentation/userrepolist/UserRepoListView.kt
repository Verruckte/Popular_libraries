package com.example.popular_libraries.presentation.userrepolist

import com.example.popular_libraries.presentation.GitHubUserRepoViewModel
import com.example.popular_libraries.presentation.ScreenView
import moxy.viewstate.strategy.alias.SingleState

interface UserRepoListView : ScreenView {

    @SingleState
    fun showUserRepo(user: List<GitHubUserRepoViewModel>)

}