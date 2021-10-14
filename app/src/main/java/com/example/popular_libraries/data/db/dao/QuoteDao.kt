package com.example.popular_libraries.data.db.dao

import androidx.room.*
import com.example.popular_libraries.data.db.StorageDB
import com.example.popular_libraries.data.entities.Quote
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(quote: Quote): Completable

    @Query("select * from ${StorageDB.TABLE_QUOTE} order by ${StorageDB.VIEWED} desc")
    fun getQuotes(): Single<List<Quote>>

    @Delete
    fun delete(quote: Quote): Completable
}