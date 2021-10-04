package com.example.popular_libraries.view

import com.example.popular_libraries.model.entity.GithubUserRepo
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView : ScreenView {
    fun showUser(user: GithubUserViewModel)
    fun updateRepos()
    fun init()
    fun showRepo(repo: GithubUserRepo)
}
