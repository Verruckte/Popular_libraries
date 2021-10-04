package com.example.popular_libraries.model.datasource

import com.example.popular_libraries.model.api.GithubApiFactory

object UsersDataSourceFactory {
    fun create() = UsersDataSourceImpl(GithubApiFactory.create())
}