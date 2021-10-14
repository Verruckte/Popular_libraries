package com.example.popular_libraries.basic.setting

import com.example.popular_libraries.basic.BasePresenter
import com.example.popular_libraries.data.db.StorageDB
import com.example.popular_libraries.data.db.repositories.SettingDB
import com.example.popular_libraries.data.entities.Setting
import com.example.popular_libraries.data.events.BaseHandler
import com.example.popular_libraries.data.events.UpdatePeriodEvent
import com.example.popular_libraries.helpers.shedules.AppSchedulers
import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.kotlin.plusAssign

class SettingPresenter @AssistedInject constructor(
    router: Router,
    private val settingDB: SettingDB,
    private val schedulers: AppSchedulers,
    private val baseHandler: BaseHandler,
) : BasePresenter<SettingView>(router) {

    override fun attachView(view: SettingView?) {
        super.attachView(view)
        viewState.init()
        loadData()
    }

    fun savePeriodUpdate(value: Int) {
        disposables += settingDB.save(
            Setting(
                StorageDB.PARAM_PERIOD_UPDATE,
            value = value.toString())
        )
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .subscribe(
                {
                    baseHandler.send(UpdatePeriodEvent(value))
                },

                { exception ->
                    viewState.endLoadData()
                    viewState.showException(exception)
                }
            )
    }

    private fun loadData() {
        viewState.startLoadData()
        disposables += settingDB.getSettings()
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .subscribe(
                { settings ->
                    viewState.endLoadData()
                    viewState.showSettings(settings)
                },

                { exception ->
                    viewState.endLoadData()
                    viewState.showException(exception)
                }
            )
    }
}