package com.example.popular_libraries.model.datasource

import com.example.popular_libraries.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single

interface CacheUsersDataSource : UsersDataSource {
    fun retain(users: List<GithubUser>): Single<List<GithubUser>>
    fun retain(user: GithubUser): Single<GithubUser>
}