package com.example.popular_libraries.presenter

import com.example.popular_libraries.model.entity.GithubUser
import com.example.popular_libraries.model.entity.GithubUserRepo
import com.example.popular_libraries.model.repo.IGithubUsersRepo
import com.example.popular_libraries.view.GithubUserViewModel
import com.example.popular_libraries.view.UserRepoItemView
import com.example.popular_libraries.view.UserView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserPresenter(
    private val login: String?,
    private val repo: IGithubUsersRepo,
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()
    val reposPresenter = UserReposListPresenter()

    class UserReposListPresenter : IUserReposListPresenter {
        val repos = mutableListOf<GithubUserRepo>()
        override var itemClickListener: ((UserRepoItemView) -> Unit)? = null
        override fun bindView(view: UserRepoItemView) = view.setRepoName(repos[view.pos].name)
        override fun getCount() = repos.size
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        disposables +=
                repo.getUserByLogin(login)
                        .observeOn(Schedulers.computation())
                        .map { GithubUserViewModel.Mapper.map(it) }
                        .defaultIfEmpty(GithubUserViewModel("Unknown", "http://unknown", "http://unknown"))
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { user ->
                                    viewState.showUser(user)
                                    getUserRepos(user.repos_url)
                                    setRepoItemClickListener()
                                },
                                { error -> viewState.showToast(error.message ?: "get user error") }
                        )
    }

    private fun getUserRepos(url: String) {
        disposables +=
                repo.getUserRepos(url)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { repos ->
                                    reposPresenter.repos.apply {
                                        clear()
                                        addAll(repos)
                                    }
                                    viewState.updateRepos()
                                }, { error ->
                            viewState.showToast(error.message ?: "error get user repositories")
                        }
                        )
    }

    private fun setRepoItemClickListener() {
        reposPresenter.itemClickListener = { itemView ->
            viewState.showRepo(reposPresenter.repos[itemView.pos])
        }
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}