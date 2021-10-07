package com.example.popular_libraries.data.api


import com.example.popular_libraries.data.room.entities.RoomGithubRepository
import com.example.popular_libraries.data.room.entities.RoomGithubUser
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface GitHubApi {

    @GET("/users")
    fun getUsers(@Query("since") since: Int? = null): Single<List<RoomGithubUser>>

    @GET("/users/{username}")
    fun getUserByLogin(@Path("username") login: String): Single<RoomGithubUser>

    @GET
    fun getUserListRepo(@Url repos_url: String): Single<List<RoomGithubRepository>>
}