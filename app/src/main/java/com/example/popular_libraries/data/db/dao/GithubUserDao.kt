package com.example.popular_libraries.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.popular_libraries.data.db.AppDB
import com.example.popular_libraries.data.entity.GithubUser
import io.reactivex.rxjava3.core.Single

@Dao
interface GithubUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<GithubUser>)

    @Query("select * from ${AppDB.TABLE_USERS}")
    fun getUsers(): Single<List<GithubUser>>

    @Query("select * from ${AppDB.TABLE_USERS} where ${AppDB.LOGIN} = :userLogin")
    fun getUser(userLogin: String): Single<GithubUser>

}