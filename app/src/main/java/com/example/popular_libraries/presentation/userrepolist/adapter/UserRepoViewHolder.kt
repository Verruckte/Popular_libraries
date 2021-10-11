package com.example.popular_libraries.presentation.userrepolist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.popular_libraries.databinding.ViewUserRepoItemBinding
import com.example.popular_libraries.ext.click
import com.example.popular_libraries.ext.setStartDrawableCircleImageFromUri
import com.example.popular_libraries.presentation.GitHubUserRepoViewModel

class UserRepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val viewBinding: ViewUserRepoItemBinding by viewBinding()

    fun bind(user: GitHubUserRepoViewModel, delegate: UserRepoAdapter.Delegate?) {
        with(viewBinding) {
            userLogin.setStartDrawableCircleImageFromUri(user.name)
            userLogin.text = user.name
            root.click { delegate?.onUserPickedRepo(user) }
        }
    }

}