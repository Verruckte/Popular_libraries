package com.example.popular_libraries.presentation.userrepodetail

import com.example.popular_libraries.presentation.GitHubUserRepoViewModel
import com.example.popular_libraries.presentation.ScreenView
import moxy.viewstate.strategy.alias.SingleState

interface UserRepoDetailView : ScreenView {
    @SingleState
    fun showForkCount(user: GitHubUserRepoViewModel)
}