package com.example.popular_libraries.model.datasource


import com.example.popular_libraries.model.entity.GithubUser
import com.example.popular_libraries.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

class CacheUsersDataSourceImpl : CacheUsersDataSource {

    private val cache = mutableListOf<GithubUser>()

    override fun retain(users: List<GithubUser>): Single<List<GithubUser>> =
            Single.fromCallable {
                cache.clear()
                cache.also { it.addAll(users) }
            }

    override fun retain(user: GithubUser): Single<GithubUser> =
            Single.fromCallable { user }

    override fun getUsers(): Single<List<GithubUser>> = Single.just(cache)

    override fun getUserByLogin(login: String?): Maybe<GithubUser> =
            Maybe.defer {
                cache.firstOrNull { user -> user.login.contentEquals(login.toString()) }
                        ?.let { user -> Maybe.just(user) }
                        ?: Maybe.empty()
            }

    override fun getUserRepos(url: String): Maybe<List<GithubUserRepo>> = Maybe.empty()
}




