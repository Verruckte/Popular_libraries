package com.example.popular_libraries.helpers.di.modules

import android.content.Context
import androidx.room.Room
import com.example.popular_libraries.data.db.AppDB
import com.example.popular_libraries.helpers.di.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {

    @AppDataBase
    @Singleton
    @Provides
    fun provideAppDB(context: Context): AppDB =
        Room.databaseBuilder(context, AppDB::class.java, AppDB.DB_NAME)
            .build()

}