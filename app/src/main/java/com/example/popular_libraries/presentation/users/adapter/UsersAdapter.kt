package com.example.popular_libraries.presentation.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.popular_libraries.R.layout.view_user
import com.example.popular_libraries.presentation.GitHubUserViewModel

class UsersAdapter(private val delegate: Delegate?) :
    androidx.recyclerview.widget.ListAdapter<GitHubUserViewModel, UserViewHolder>(UserDiff) {

    interface Delegate {


        fun onUserPicked(user: GitHubUserViewModel)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(view_user, parent, false)
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)

}