package com.example.popular_libraries.helpers.di.modules

import com.example.popular_libraries.baselogic.main.MainActivity
import com.example.popular_libraries.baselogic.user.UserFragment
import com.example.popular_libraries.baselogic.userrepositories.RepositoryFragment
import com.example.popular_libraries.baselogic.users.UsersFragment
import com.example.popular_libraries.convert.ImageCompressorFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface UIModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindUserFragment(): UserFragment

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment

    @ContributesAndroidInjector
    fun bindRepositoryFragment(): RepositoryFragment

    @ContributesAndroidInjector
    fun bindImageCompressorFragment(): ImageCompressorFragment
}