package com.example.popular_libraries.basic

interface BaseListPresenter<T> {

    fun bindView(view: T)

    fun getCount(): Int
}