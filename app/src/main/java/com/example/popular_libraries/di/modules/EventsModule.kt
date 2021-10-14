package com.example.popular_libraries.di.modules

import com.example.popular_libraries.data.events.BaseHandler
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EventsModule {

    @Singleton
    @Provides
    fun providerBaseHandler() = BaseHandler()
}