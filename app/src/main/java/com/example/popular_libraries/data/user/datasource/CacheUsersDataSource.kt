package com.example.popular_libraries.data.user.datasource


import com.example.popular_libraries.data.room.entities.RoomGithubUser
import io.reactivex.Single

interface CacheUserDataSource : UserDataSource {

    fun retain(users: List<RoomGithubUser>): Single<List<RoomGithubUser>>
    fun retain(user: RoomGithubUser): Single<RoomGithubUser>
}