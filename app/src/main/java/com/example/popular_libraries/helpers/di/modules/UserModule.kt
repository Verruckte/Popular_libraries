package com.example.popular_libraries.helpers.di.modules

import com.example.popular_libraries.convert.ImageConverter
import com.example.popular_libraries.convert.ImageConverterImpl
import com.example.popular_libraries.data.db.cache.GithubCache
import com.example.popular_libraries.data.db.cache.GithubCacheImpl
import com.example.popular_libraries.data.repositories.GithubUsersRepository
import com.example.popular_libraries.data.repositories.GithubUsersRepositoryImpl
import com.example.popular_libraries.data.repositories.UserAvatarRepository
import com.example.popular_libraries.data.repositories.UserAvatarRepositoryImpl
import com.example.popular_libraries.helpers.NetworkStatus
import com.example.popular_libraries.helpers.NetworkStatusImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface UserModule {

    @Singleton
    @Binds
    fun bindGithubUsersRepository(repository: GithubUsersRepositoryImpl): GithubUsersRepository

    @Singleton
    @Binds
    fun bindGithubCache(githubCache: GithubCacheImpl): GithubCache

    @Singleton
    @Binds
    fun bindNetworkStatus(networkStatus: NetworkStatusImpl): NetworkStatus

    @Binds
    fun bindImageConverter(imageConverter: ImageConverterImpl): ImageConverter

    @Singleton
    @Binds
    fun bindUserAvatarRepository(userAvatarRepository: UserAvatarRepositoryImpl): UserAvatarRepository

}