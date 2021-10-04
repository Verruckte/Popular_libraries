package com.example.popular_libraries.model.datasource

import com.example.popular_libraries.model.entity.GithubUser
import com.example.popular_libraries.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface UsersDataSource {

    fun getUsers(): Single<List<GithubUser>>
    fun getUserByLogin(login: String?): Maybe<GithubUser>
    fun getUserRepos(url: String): Maybe<List<GithubUserRepo>>

}