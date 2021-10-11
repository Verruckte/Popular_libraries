package com.example.popular_libraries.baselogic.users

import com.example.popular_libraries.baselogic.ExceptionView
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface UsersView : MvpView, ExceptionView {

    fun init()

    fun updateList()
}