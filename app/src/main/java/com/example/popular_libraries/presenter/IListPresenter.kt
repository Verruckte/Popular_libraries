package com.example.popular_libraries.presenter

import com.example.popular_libraries.view.IItemView
import com.example.popular_libraries.view.UserItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}