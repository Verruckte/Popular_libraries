package com.example.popular_libraries.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.popular_libraries.databinding.ViewUserBinding
import com.example.popular_libraries.ext.click
import com.example.popular_libraries.ext.setStartDrawableCircleImageFromUri
import com.example.popular_libraries.presentation.GitHubUserViewModel

class UserViewHolder(view: View) : ViewHolder(view) {

    private val viewBinding: ViewUserBinding by viewBinding()

    fun bind(user: GitHubUserViewModel, delegate: UsersAdapter.Delegate?) {
        with(viewBinding) {
            userLogin.setStartDrawableCircleImageFromUri(user.avatar)
            userLogin.text = user.login

            root.click { delegate?.onUserPicked(user) }
        }
    }
}