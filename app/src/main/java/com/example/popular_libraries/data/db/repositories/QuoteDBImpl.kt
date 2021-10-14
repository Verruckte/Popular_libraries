package com.example.popular_libraries.data.db.repositories

import com.example.popular_libraries.data.db.StorageDB
import com.example.popular_libraries.data.entities.Quote
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class QuoteDBImpl @Inject constructor(private val storageDB: StorageDB) : QuoteDB {

    override fun insert(quote: Quote) = storageDB.quoteDao().insert(quote)

    override fun getQuotes(): Single<List<Quote>> = storageDB.quoteDao().getQuotes()

    override fun delete(quote: Quote) = storageDB.quoteDao().delete(quote)
}