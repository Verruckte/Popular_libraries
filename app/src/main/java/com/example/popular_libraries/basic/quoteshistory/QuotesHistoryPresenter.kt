package com.example.popular_libraries.basic.quoteshistory


import com.example.popular_libraries.basic.BasePresenter
import com.example.popular_libraries.data.db.repositories.QuoteDB
import com.example.popular_libraries.data.entities.Quote
import com.example.popular_libraries.helpers.shedules.AppSchedulers
import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.kotlin.plusAssign

class QuotesHistoryPresenter @AssistedInject constructor(
    router: Router,
    private val quoteDB: QuoteDB,
    private val schedulers: AppSchedulers,
) : BasePresenter<QuotesHistoryView>(router), QuoteHistoryListPresenter {

    private val quotes = mutableListOf<Quote>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    override fun bindView(view: QuoteItemView) {
        view.setData(quotes[view.currentPosition])
    }

    override fun getCount() = quotes.size

    private fun loadData() {
        disposables +=
            quoteDB
                .getQuotes()
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    { quotesDB ->
                        quotes.addAll(quotesDB)
                        viewState.updateList()
                    },
                    { exception -> viewState.showException(exception) }
                )
    }
}