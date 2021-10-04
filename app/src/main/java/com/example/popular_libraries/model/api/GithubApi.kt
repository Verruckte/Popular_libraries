package com.example.popular_libraries.model.api

import com.example.popular_libraries.model.entity.GithubUser
import com.example.popular_libraries.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface GithubApi {

    @GET("/users")
    fun getUsers(@Query("since") since: Int? = null): Single<List<GithubUser>>

    @GET("/users/{username}")
    fun getUserByLogin(@Path("username") login: String): Single<GithubUser>

    @GET
    fun getUserRepos(@Url url: String): Single<List<GithubUserRepo>>
}