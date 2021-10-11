package com.example.popular_libraries.presentation.users

import com.example.popular_libraries.presentation.user.UserScreen
import com.example.popular_libraries.data.user.GitHubUserRepository
import com.example.popular_libraries.presentation.GitHubUserViewModel
import com.example.popular_libraries.sheduler.Schedulers
import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router,
    private val schedulers: Schedulers,
) : MvpPresenter<UsersView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            userRepository
                .getUsers()
                .observeOn(schedulers.background())
                .map { users -> users.map(GitHubUserViewModel.Mapper::map) }
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showUsers,
                    viewState::showError
                )
    }

    fun displayUser(user: GitHubUserViewModel) {
        router.navigateTo(UserScreen(user.login))
    }

    override fun onDestroy() {
        disposables.dispose()
    }
}