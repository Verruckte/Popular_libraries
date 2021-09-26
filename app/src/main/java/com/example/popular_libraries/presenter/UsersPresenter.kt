package com.example.popular_libraries.presenter

import com.example.popular_libraries.model.GithubUser
import com.example.popular_libraries.model.GithubUsersRepo
import com.example.popular_libraries.view.UserItemView
import com.example.popular_libraries.view.UsersView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GithubUsersRepo,
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<UsersView>() {
    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(screens.user(user))
        }
    }

    private fun loadData() {
        usersRepo.getUsers().subscribe { users -> usersListPresenter.users.addAll(users) }
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}