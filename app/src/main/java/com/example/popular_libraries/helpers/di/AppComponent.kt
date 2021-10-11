package com.example.popular_libraries.helpers.di

import android.content.Context
import com.example.popular_libraries.App
import com.example.popular_libraries.helpers.di.modules.ApiModule
import com.example.popular_libraries.helpers.di.modules.DBModule
import com.example.popular_libraries.helpers.di.modules.UIModule
import com.example.popular_libraries.helpers.di.modules.UserModule
import com.example.popular_libraries.helpers.shedules.AppSchedulers
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    UserModule::class,
    ApiModule::class,
    DBModule::class,
    UIModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigationHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withAppScheduler(appSchedulers: AppSchedulers): Builder

        fun build(): AppComponent
    }
}