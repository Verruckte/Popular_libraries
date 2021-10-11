package com.example.popular_libraries.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.popular_libraries.data.db.AppDB
import com.example.popular_libraries.data.entity.GithubUserRepository
import io.reactivex.rxjava3.core.Single

@Dao
interface GithubUserRepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repositories: List<GithubUserRepository>)

    @Query("select r.* " +
            "from ${AppDB.TABLE_USER_REPOSITORIES} r, " +
            "${AppDB.TABLE_USERS} u " +
            "where r.${AppDB.USER_ID} = u.${AppDB.USER_ID} " +
            "and u.${AppDB.LOGIN} = :userLogin")
    fun getRepositories(userLogin: String): Single<List<GithubUserRepository>>

    @Query("select r.* " +
            "from ${AppDB.TABLE_USER_REPOSITORIES} r, " +
            "${AppDB.TABLE_USERS} u " +
            "where r.${AppDB.NAME} = :repositoryName " +
            "and r.${AppDB.USER_ID} = u.${AppDB.USER_ID} " +
            "and u.${AppDB.LOGIN} = :userLogin")
    fun getRepositoryOnUserLogin(
        userLogin: String,
        repositoryName: String,
    ): Single<GithubUserRepository>

}