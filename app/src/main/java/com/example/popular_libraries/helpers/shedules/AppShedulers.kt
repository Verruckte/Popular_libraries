package com.example.popular_libraries.helpers.shedules

import io.reactivex.rxjava3.core.Scheduler

interface AppSchedulers {

    fun background(): Scheduler
    fun main(): Scheduler
}
