package com.example.popular_libraries.presenter

import com.example.popular_libraries.view.MainView
import com.example.popular_libraries.view.UsersScreen
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter


class MainPresenter(
        private val router: Router,
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(UsersScreen.create())
    }

    fun back() = router.exit()
}