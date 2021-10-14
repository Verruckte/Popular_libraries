package com.example.popular_libraries.basic.main

import com.example.popular_libraries.basic.BasePresenter
import com.example.popular_libraries.basic.quote.QuoteScreen
import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import moxy.MvpView

class MainPresenter @AssistedInject constructor(
    router: Router,
) : BasePresenter<MvpView>(router) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(QuoteScreen())
    }
}