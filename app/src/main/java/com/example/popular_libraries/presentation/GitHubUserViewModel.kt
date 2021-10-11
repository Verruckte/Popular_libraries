package com.example.popular_libraries.presentation

import com.example.popular_libraries.data.room.entities.RoomGithubUser

data class GitHubUserViewModel(
    val login: String,
    val avatar: String,
    val repos_url: String,
) {

    object Mapper {

        fun map(user: RoomGithubUser) =
            GitHubUserViewModel(
                user.login,
                user.avatar,
                user.repos_url
            )
    }
}