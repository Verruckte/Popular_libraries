package com.example.popular_libraries.data.db.repositories

import com.example.popular_libraries.data.entities.Quote
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface QuoteDB {

    fun insert(quote: Quote): Completable

    fun getQuotes(): Single<List<Quote>>

    fun delete(quote: Quote): Completable
}