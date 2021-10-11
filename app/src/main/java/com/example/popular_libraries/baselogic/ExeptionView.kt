package com.example.popular_libraries.baselogic

import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface ExceptionView {
    fun showException(throwable: Throwable)
}