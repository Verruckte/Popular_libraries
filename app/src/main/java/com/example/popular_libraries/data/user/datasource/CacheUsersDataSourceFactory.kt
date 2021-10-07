package com.example.popular_libraries.data.user.datasource

import com.example.popular_libraries.App
import com.example.popular_libraries.data.room.GitHubStorageFactory

object CacheUserDataSourceFactory {

    fun create(): CacheUserDataSource =
        CacheUserDataSourceImpl(
            GitHubStorageFactory.create(App.ContextHolder.context)
        )
}