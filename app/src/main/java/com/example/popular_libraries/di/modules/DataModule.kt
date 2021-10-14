package com.example.popular_libraries.di.modules

import com.example.popular_libraries.data.QuoteRepository
import com.example.popular_libraries.data.QuoteRepositoryImpl
import com.example.popular_libraries.data.db.repositories.QuoteDB
import com.example.popular_libraries.data.db.repositories.QuoteDBImpl
import com.example.popular_libraries.data.db.repositories.SettingDB
import com.example.popular_libraries.data.db.repositories.SettingDBImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataModule {
    @Singleton
    @Binds
    fun bindQuoteRepository(repository: QuoteRepositoryImpl): QuoteRepository

    @Singleton
    @Binds
    fun bindQuoteDB(quoteDB: QuoteDBImpl): QuoteDB

    @Singleton
    @Binds
    fun bindSettingDB(settingDB: SettingDBImpl): SettingDB
}