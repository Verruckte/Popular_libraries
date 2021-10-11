package com.example.popular_libraries.data.db.cache

import com.example.popular_libraries.data.entity.GithubUser
import com.example.popular_libraries.data.entity.GithubUserRepository
import io.reactivex.rxjava3.core.Single

interface GithubCache {

    fun insertUsers(users: List<GithubUser>)

    fun getUsers(): Single<List<GithubUser>>

    fun getUser(userLogin: String): Single<GithubUser>

    fun insertRepository(repository: GithubUserRepository)

    fun insertRepositories(repositories: List<GithubUserRepository>)

    fun getRepositoriesOnUserLogin(userLogin: String): Single<List<GithubUserRepository>>

    fun getRepositoryOnUserLogin(
        userLogin: String,
        repositoryName: String,
    ): Single<GithubUserRepository>
}