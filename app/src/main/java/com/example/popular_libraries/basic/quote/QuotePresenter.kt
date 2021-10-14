package com.example.popular_libraries.basic.quote

import com.example.popular_libraries.basic.BasePresenter
import com.example.popular_libraries.basic.quoteshistory.QuotesHistoryScreen
import com.example.popular_libraries.data.QuoteRepository
import com.example.popular_libraries.data.db.StorageDB
import com.example.popular_libraries.data.db.repositories.QuoteDB
import com.example.popular_libraries.data.db.repositories.SettingDB
import com.example.popular_libraries.data.events.BaseHandler
import com.example.popular_libraries.data.events.UpdatePeriodEvent
import com.example.popular_libraries.helpers.shedules.AppSchedulers
import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class QuotePresenter @AssistedInject constructor(
    router: Router,
    private val quoteDB: QuoteDB,
    private val settingDB: SettingDB,
    private val quoteRepository: QuoteRepository,
    private val schedulers: AppSchedulers,
    private val baseHandler: BaseHandler,
) : BasePresenter<QuoteView>(router) {

    private val timer = CompositeDisposable()
    private var periodUpdate = StorageDB.PERIOD_UPDATE_DEFAULT
    private var reverseTimerValue = StorageDB.PERIOD_UPDATE_DEFAULT

    override fun attachView(view: QuoteView?) {
        super.attachView(view)
        viewState.init()

        disposables += baseHandler.addHandler(UpdatePeriodEvent::class) { updatePeriodEvent ->
            periodUpdate = updatePeriodEvent.newPeriod
            reverseTimerValue = periodUpdate
        }

        loadData()
        loadPeriodUpdate()
        initTimer()
    }

    override fun detachView(view: QuoteView?) {
        super.detachView(view)
        timer.clear()
    }

    fun updateQuote() {
        reverseTimerValue = periodUpdate
        loadData()
    }

    fun openHistory() {
        router.navigateTo(QuotesHistoryScreen())
    }

    private fun loadData() {
        viewState.startUpdateQuote()
        disposables += quoteRepository.getQuote()
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .map { quote ->
                quote.viewed = System.currentTimeMillis()
                quoteDB
                    .insert(quote)
                    .observeOn(schedulers.main())
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {},
                        { exception -> viewState.showException(exception) }
                    )
                return@map quote
            }
            .subscribe(
                { quote ->
                    viewState.endUpdateQuote()
                    viewState.showQuote(quote)
                },

                { exception ->
                    viewState.endUpdateQuote()
                    viewState.showException(exception)
                }
            )
    }

    private fun loadPeriodUpdate() {
        disposables += settingDB.getSetting(StorageDB.PARAM_PERIOD_UPDATE)
            .observeOn(schedulers.main())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { setting ->
                    setting?.let {
                        periodUpdate = it.value.toInt()
                        initTimer()
                    } ?: StorageDB.PERIOD_UPDATE_DEFAULT
                    reverseTimerValue = periodUpdate
                },
                {
                    periodUpdate = StorageDB.PERIOD_UPDATE_DEFAULT
                    reverseTimerValue = periodUpdate
                }
            )
    }

    private fun initTimer() {
        timer.clear()
        timer += Observable.interval(1, 1, TimeUnit.SECONDS)
            .subscribeOn(schedulers.background())
            .observeOn(schedulers.main())
            .subscribe { processTimer() }
    }

    private fun processTimer() {
        --reverseTimerValue
        if (reverseTimerValue == 0) {
            reverseTimerValue = periodUpdate
            loadData()
        }
        viewState.showReverseTimer(reverseTimerValue)
    }
}