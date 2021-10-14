package com.example.popular_libraries.helpers.shedules

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class AppSchedulersImpl : AppSchedulers {
    override fun background(): Scheduler = Schedulers.newThread()

    override fun main(): Scheduler = AndroidSchedulers.mainThread()
}