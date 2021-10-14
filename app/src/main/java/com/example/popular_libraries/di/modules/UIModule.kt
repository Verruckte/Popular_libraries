package com.example.popular_libraries.di.modules

import com.example.popular_libraries.basic.main.MainActivity
import com.example.popular_libraries.basic.quote.QuoteFragment
import com.example.popular_libraries.basic.quoteshistory.QuotesHistoryFragment
import com.example.popular_libraries.basic.setting.SettingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface UIModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindQuoteFragment(): QuoteFragment

    @ContributesAndroidInjector
    fun bindQuotesHistoryFragment(): QuotesHistoryFragment

    @ContributesAndroidInjector
    fun bindSettingFragment(): SettingFragment
}