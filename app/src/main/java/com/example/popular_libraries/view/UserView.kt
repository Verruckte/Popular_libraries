package com.example.popular_libraries.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState

@SingleState()
interface UserView : MvpView {
    fun setLogin(text: String)
}
