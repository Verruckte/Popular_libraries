package com.example.popular_libraries.data.api


import com.example.popular_libraries.data.entities.Quote
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ForismaticApi {

    @POST("1.0/")
    @FormUrlEncoded
    fun getQuote(
        @Field("method") method: String = "getQuote",
        @Field("format") format: String = "json",
        @Field("lang") lang: String = "ru",
    ): Single<Quote>
}