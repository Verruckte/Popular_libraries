package com.example.popular_libraries.data.user

import com.example.popular_libraries.data.room.entities.RoomGithubRepository
import com.example.popular_libraries.data.room.entities.RoomGithubUser
import com.example.popular_libraries.data.user.datasource.CacheUserDataSource
import com.example.popular_libraries.data.user.datasource.UserDataSource
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

class GitHubUserRepositoryImpl(
    private val cloud: UserDataSource,
    private val cache: CacheUserDataSource,
) : GitHubUserRepository {

    override fun getUsers(): Observable<List<RoomGithubUser>> =
        Observable.merge(
            cache.getUsers().toObservable(),
            cloud.getUsers().flatMap(cache::retain).toObservable()
        )

    override fun getUserByLogin(userId: String): Maybe<RoomGithubUser> =
        cache.getUserByLogin(userId)
            .onErrorResumeNext(
                cloud.getUserByLogin(userId)
            )

    override fun getUserListRepo(userId: String): Single<List<RoomGithubRepository>> =
        cloud.getUserListRepo(userId)
}