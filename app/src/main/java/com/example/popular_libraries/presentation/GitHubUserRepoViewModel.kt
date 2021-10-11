package com.example.popular_libraries.presentation

import com.example.popular_libraries.data.room.entities.RoomGithubRepository

data class GitHubUserRepoViewModel(
    val name: String,
    val description: String,
    val language: String,
    val forks_count: Int,
) {

    object Mapper {

        fun map(user: RoomGithubRepository) =
            GitHubUserRepoViewModel(
                user.name,
                user.description!!,
                user.language,
                user.forks_count
            )
    }
}