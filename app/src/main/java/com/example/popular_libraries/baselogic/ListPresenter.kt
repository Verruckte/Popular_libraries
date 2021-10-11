package com.example.popular_libraries.baselogic

interface ListPresenter<T> {

    var itemClickListener: ((T) -> Unit)?

    fun bindView(view: T)

    fun getCount(): Int
}