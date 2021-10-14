package com.example.popular_libraries.basic.quoteshistory

import dagger.assisted.AssistedFactory

@AssistedFactory
interface QuotesHistoryPresenterFactory {
    fun create(): QuotesHistoryPresenter
}