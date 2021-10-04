package com.example.popular_libraries.view

import com.example.popular_libraries.model.entity.GithubUser

data class GithubUserViewModel(
    val login: String,
    val avatar_url: String,
    val repos_url: String,
) {
    object Mapper {
        fun map(user: GithubUser) = GithubUserViewModel(
            user.login, user.avatar, user.repos_url
        )
    }
}