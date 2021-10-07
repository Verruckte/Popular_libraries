package com.example.popular_libraries.presentation.userrepolist

import com.example.popular_libraries.data.user.GitHubUserRepository
import com.example.popular_libraries.presentation.GitHubUserRepoViewModel
import com.example.popular_libraries.presentation.userrepodetail.UserRepoDetailScreen
import com.example.popular_libraries.sheduler.Schedulers
import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter

class UserRepoListPresenter(
    private val repos_url: String,
    private val router: Router,
    private val userRepository: GitHubUserRepository,
    private val schedulers: Schedulers,
) : MvpPresenter<UserRepoListView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            userRepository
                .getUserListRepo(repos_url)
                .observeOn(schedulers.background())
                .map { users -> users.map(GitHubUserRepoViewModel.Mapper::map) }
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showUserRepo,
                    viewState::showError
                )
    }

    fun displayUserRepoDetail(detailRepo: GitHubUserRepoViewModel) {
        router.navigateTo(UserRepoDetailScreen(detailRepo.forks_count.toString()))
    }

    override fun onDestroy() {
        disposables.clear()
    }

}