package com.example.popular_libraries.model.api

import com.example.popular_libraries.BuildConfig.GITHUB_USER_NAME
import com.example.popular_libraries.BuildConfig.GITHUB_USER_PASS
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response


object GithubApiInterceptor : Interceptor {


        override fun intercept(chain: Interceptor.Chain): Response =
                chain.proceed(
                        chain.request()
                            .newBuilder()
                            .header("Authorization", Credentials.basic(GITHUB_USER_NAME, GITHUB_USER_PASS))
                            .build()
            )
}