package com.example.popular_libraries.basic.quoteshistory

import com.example.popular_libraries.data.entities.Quote

interface QuoteItemView {
    var currentPosition: Int

    fun setData(quote: Quote)
}