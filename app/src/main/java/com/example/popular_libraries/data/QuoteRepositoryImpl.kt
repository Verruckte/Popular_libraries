package com.example.popular_libraries.data

import com.example.popular_libraries.data.api.ForismaticApi
import com.example.popular_libraries.data.entities.Quote
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val forismaticApi: ForismaticApi,
) : QuoteRepository {

    override fun getQuote(): Single<Quote> = forismaticApi.getQuote()
}