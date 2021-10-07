package com.example.popular_libraries.data.room.dao

import androidx.room.*
import com.example.popular_libraries.data.room.entities.RoomGithubRepository
import io.reactivex.Single

@Dao
interface RepositoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomGithubRepository)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: RoomGithubRepository)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RoomGithubRepository>)

    @Update
    fun update(user: RoomGithubRepository)

    @Update
    fun update(vararg users: RoomGithubRepository)

    @Update
    fun update(users: List<RoomGithubRepository>)

    @Delete
    fun delete(user: RoomGithubRepository)

    @Delete
    fun delete(vararg users: RoomGithubRepository)

    @Delete
    fun delete(users: List<RoomGithubRepository>)

    @Query("SELECT * FROM user_repos")
    fun getAll(): List<RoomGithubRepository>

    @Query("SELECT * FROM user_repos WHERE userId = :userId")
    fun findForUser(userId: String): List<RoomGithubRepository>

    @Query("SELECT * FROM user_repos WHERE userId LIKE  :userId")
    fun getUserListRepo(userId: String): Single<List<RoomGithubRepository>>
}