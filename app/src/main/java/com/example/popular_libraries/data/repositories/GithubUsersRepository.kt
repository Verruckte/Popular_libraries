package com.example.popular_libraries.data.repositories

import com.example.popular_libraries.data.entity.GithubUser
import com.example.popular_libraries.data.entity.GithubUserRepository
import io.reactivex.rxjava3.core.Single

interface GithubUsersRepository {
    fun getUsers(): Single<List<GithubUser>>

    fun getUser(userLogin: String): Single<GithubUser>

    fun getRepositories(login: String): Single<List<GithubUserRepository>>

    fun getRepository(login: String, repositoryName: String): Single<GithubUserRepository>
}