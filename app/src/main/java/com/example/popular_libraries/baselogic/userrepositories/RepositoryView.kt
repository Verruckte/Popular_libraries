package com.example.popular_libraries.baselogic.userrepositories

import com.example.popular_libraries.baselogic.ExceptionView
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface RepositoryView : MvpView, ExceptionView {

    fun showInfo(text: String)
}