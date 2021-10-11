package com.example.popular_libraries.baselogic.user

import com.example.popular_libraries.baselogic.ListPresenter
import com.example.popular_libraries.baselogic.userrepositories.RepositoryItemView
import com.example.popular_libraries.data.entity.GithubUserRepository

class RepositoryListPresenter : ListPresenter<RepositoryItemView> {
    val repositories = mutableListOf<GithubUserRepository>()

    override var itemClickListener: ((RepositoryItemView) -> Unit)? = null

    override fun getCount() = repositories.size

    override fun bindView(view: RepositoryItemView) {
        val repository = repositories[view.currentPosition]
        view.setName(repository.fullName)
    }
}