package com.example.popular_libraries.data.user

import com.example.popular_libraries.data.user.datasource.CacheUserDataSourceFactory
import com.example.popular_libraries.data.user.datasource.UserDataSourceFactory

object GitHubUserRepositoryFactory {

    private val repository: GitHubUserRepository by lazy {
        GitHubUserRepositoryImpl(
            UserDataSourceFactory.create(),
            CacheUserDataSourceFactory.create()
        )
    }

    fun create(): GitHubUserRepository = repository
}