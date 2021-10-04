package com.example.popular_libraries.model.repo

import com.example.popular_libraries.model.datasource.CacheUsersDataSourceFactory
import com.example.popular_libraries.model.datasource.UsersDataSourceFactory

object GithubUsersRepoFactory {
    fun create(): IGithubUsersRepo = GithubUsersRepo(
            UsersDataSourceFactory.create(),
            CacheUsersDataSourceFactory.create())
}