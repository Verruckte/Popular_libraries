package com.example.popular_libraries.data.db.cache

import com.example.popular_libraries.data.db.AppDB
import com.example.popular_libraries.data.entity.GithubUser
import com.example.popular_libraries.data.entity.GithubUserRepository
import com.example.popular_libraries.helpers.di.AppDataBase
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubCacheImpl @Inject constructor(@AppDataBase private val appDB: AppDB) : GithubCache {

    override fun insertUsers(users: List<GithubUser>) {
        appDB.githubUserDao().insert(users)
    }

    override fun getUsers(): Single<List<GithubUser>> = appDB.githubUserDao().getUsers()

    override fun getUser(userLogin: String): Single<GithubUser> =
        appDB.githubUserDao().getUser(userLogin)

    override fun insertRepository(repository: GithubUserRepository) {
        appDB.githubUserRepositoryDao().insert(listOf(repository))
    }

    override fun insertRepositories(repositories: List<GithubUserRepository>) {
        appDB.githubUserRepositoryDao().insert(repositories)
    }

    override fun getRepositoriesOnUserLogin(userLogin: String): Single<List<GithubUserRepository>> =
        appDB.githubUserRepositoryDao().getRepositories(userLogin)

    override fun getRepositoryOnUserLogin(
        userLogin: String,
        repositoryName: String,
    ): Single<GithubUserRepository> =
        appDB.githubUserRepositoryDao().getRepositoryOnUserLogin(userLogin, repositoryName)
}