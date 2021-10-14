package com.example.popular_libraries.basic.quoteshistory

import com.example.popular_libraries.basic.ExceptionView
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface QuotesHistoryView : MvpView, ExceptionView {

    fun init()

    fun updateList()
}