package com.example.popular_libraries.view

interface UserItemView : IItemView {
    fun setUser(login: String, avatar_url: String)
}