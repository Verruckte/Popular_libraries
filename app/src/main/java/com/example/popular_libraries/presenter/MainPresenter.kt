package com.example.popular_libraries.presenter

import com.example.popular_libraries.R
import com.example.popular_libraries.model.CountersModel
import com.example.popular_libraries.utils.Numbers
import com.example.popular_libraries.view.MainView


class MainPresenter(val view: MainView) {
    private val model = CountersModel()

    fun counterClick(buttonCounterNumber: Numbers) {
        when (buttonCounterNumber) {
            Numbers.ONE -> view.setButton1Text(model.next(0).toString())
            Numbers.TWO -> view.setButton2Text(model.next(1).toString())
            Numbers.THREE -> view.setButton3Text(model.next(2).toString())
        }
    }

}
