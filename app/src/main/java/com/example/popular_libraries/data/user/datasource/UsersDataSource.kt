package com.example.popular_libraries.data.user.datasource

import com.example.popular_libraries.data.room.entities.RoomGithubRepository
import com.example.popular_libraries.data.room.entities.RoomGithubUser
import io.reactivex.Maybe
import io.reactivex.Single


interface UserDataSource {

    fun getUsers(): Single<List<RoomGithubUser>>
    fun getUserByLogin(userId: String): Maybe<RoomGithubUser>
    fun getUserListRepo(reposUrl: String): Single<List<RoomGithubRepository>>
}