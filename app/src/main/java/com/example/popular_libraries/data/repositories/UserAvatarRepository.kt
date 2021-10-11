package com.example.popular_libraries.data.repositories

import android.graphics.drawable.Drawable
import com.bumptech.glide.RequestBuilder
import com.example.popular_libraries.data.entity.GithubUser

interface UserAvatarRepository {

    fun imageBuilder(user: GithubUser): RequestBuilder<Drawable>
}