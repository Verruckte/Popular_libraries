package com.example.popular_libraries.view

import com.example.popular_libraries.App.Navigation.navigatorHolder
import com.example.popular_libraries.App.Navigation.router
import com.example.popular_libraries.R
import com.example.popular_libraries.presenter.BackButtonListener
import com.example.popular_libraries.presenter.MainPresenter
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    private val presenter by moxyPresenter { MainPresenter(router) }
    private val navigator = AppNavigator(this, R.id.container)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.back()
    }
}