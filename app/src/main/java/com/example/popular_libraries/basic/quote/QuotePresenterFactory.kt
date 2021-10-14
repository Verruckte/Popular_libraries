package com.example.popular_libraries.basic.quote

import dagger.assisted.AssistedFactory

@AssistedFactory
interface QuotePresenterFactory {
    fun create(): QuotePresenter
}