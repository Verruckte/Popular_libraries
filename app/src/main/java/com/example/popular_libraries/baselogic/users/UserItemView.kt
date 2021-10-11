package com.example.popular_libraries.baselogic.users

import com.example.popular_libraries.data.entity.GithubUser

interface UserItemView {
    var currentPosition: Int

    fun setLogin(text: String)

    fun setAvatar(user: GithubUser)
}