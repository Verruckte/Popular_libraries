package com.example.popular_libraries.api




import com.example.popular_libraries.data.entity.GithubUser
import com.example.popular_libraries.data.entity.GithubUserRepository
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubApi {


    @GET("users")
    fun getUsers(): Single<List<GithubUser>>


    @GET("users/{login}")
    fun getUser(@Path("login") login: String): Single<GithubUser>


    @GET("users/{login}/repos")
    fun getRepositories(@Path("login") login: String): Single<List<GithubUserRepository>>


    @GET("repos/{login}/{repository}")
    fun getRepository(
        @Path("login") login: String,
        @Path("repository") repository: String,
    ): Single<GithubUserRepository>
}