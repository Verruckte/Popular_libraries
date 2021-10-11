package com.example.popular_libraries.data.user.datasource

import com.example.popular_libraries.data.api.GitHubApiFactory


object UserDataSourceFactory {

    fun create(): UserDataSource = CloudUserDataSource(GitHubApiFactory.create())
}