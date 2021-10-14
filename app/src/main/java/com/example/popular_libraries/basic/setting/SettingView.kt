package com.example.popular_libraries.basic.setting

import com.example.popular_libraries.basic.ExceptionView
import com.example.popular_libraries.data.entities.Setting
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface SettingView : MvpView, ExceptionView {

    fun init()

    fun startLoadData()

    fun endLoadData()

    fun showSettings(settings: List<Setting>)
}