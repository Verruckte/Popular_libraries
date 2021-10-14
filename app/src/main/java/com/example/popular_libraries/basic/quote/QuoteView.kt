package com.example.popular_libraries.basic.quote

import com.example.popular_libraries.basic.ExceptionView
import com.example.popular_libraries.data.entities.Quote
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface QuoteView : MvpView, ExceptionView {

    fun init()

    fun startUpdateQuote()

    fun endUpdateQuote()

    fun showQuote(quote: Quote)

    fun showReverseTimer(value: Int)
}