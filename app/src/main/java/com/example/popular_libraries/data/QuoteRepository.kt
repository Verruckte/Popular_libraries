package com.example.popular_libraries.data

import com.example.popular_libraries.data.entities.Quote
import io.reactivex.rxjava3.core.Single

interface QuoteRepository {

    fun getQuote(): Single<Quote>
}