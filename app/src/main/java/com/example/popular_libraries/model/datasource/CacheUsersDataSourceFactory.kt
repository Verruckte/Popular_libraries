package com.example.popular_libraries.model.datasource

object CacheUsersDataSourceFactory {
    fun create(): CacheUsersDataSource = CacheUsersDataSourceImpl()
}