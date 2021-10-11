package com.example.popular_libraries.presentation.user


import com.example.popular_libraries.data.user.GitHubUserRepository
import com.example.popular_libraries.presentation.GitHubUserViewModel
import com.example.popular_libraries.presentation.userrepolist.UserRepoListScreen
import com.example.popular_libraries.sheduler.Schedulers
import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter

class UserPresenter(
    private val userLogin: String,
    private val router: Router,
    private val userRepository: GitHubUserRepository,
    private val schedulers: Schedulers,
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            userRepository
                .getUserByLogin(userLogin)
                .map(GitHubUserViewModel.Mapper::map)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showUser,
                    viewState::showError
                )
    }

    fun displayUserRepos(user: GitHubUserViewModel) {
        router.navigateTo(UserRepoListScreen(user.repos_url))
    }

    override fun onDestroy() {
        disposables.clear()
    }
}