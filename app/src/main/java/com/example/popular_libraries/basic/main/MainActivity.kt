package com.example.popular_libraries.basic.main

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.popular_libraries.R
import com.example.popular_libraries.basic.listeners.BackButtonListener
import com.example.popular_libraries.databinding.MainActivityBinding
import com.example.popular_libraries.di.BaseDaggerActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpView
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity: BaseDaggerActivity(), MvpView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var mainPresenterFactory: MainPresenterFactory

    private val binding: MainActivityBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val navigator = AppNavigator(this, R.id.container)
    private val presenter by moxyPresenter { mainPresenterFactory.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && (it as BackButtonListener).backPressed()) {
                return
            }
        }
        super.onBackPressed()
    }
}