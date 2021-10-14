package com.example.popular_libraries.basic.main

import dagger.assisted.AssistedFactory


@AssistedFactory
interface MainPresenterFactory {
    fun create(): MainPresenter
}