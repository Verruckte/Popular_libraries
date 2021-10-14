package com.example.popular_libraries.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.popular_libraries.data.db.dao.QuoteDao
import com.example.popular_libraries.data.db.dao.SettingDao
import com.example.popular_libraries.data.entities.Quote
import com.example.popular_libraries.data.entities.Setting

@Database(
    entities = [Quote::class, Setting::class],
    version = StorageDB.DB_VERSION,
    exportSchema = false)
abstract class StorageDB : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao
    abstract fun settingDao(): SettingDao

    companion object {
        const val DB_VERSION = 2
        const val DB_NAME = "quote.db"
        const val TABLE_QUOTE = "quotes"
        const val TABLE_SETTING = "settings"
        const val QUOTE_ID = "quote_id"
        const val QUOTE_TEXT = "quote_text"
        const val QUOTE_AUTHOR = "quote_author"
        const val QUOTE_LINK = "quote_link"
        const val VIEWED = "viewed"
        const val SETTING_NAME = "name"
        const val SETTING_VALUE = "value"
        const val PARAM_PERIOD_UPDATE = "periodUpdate"
        const val PERIOD_UPDATE_DEFAULT = 30
    }
}