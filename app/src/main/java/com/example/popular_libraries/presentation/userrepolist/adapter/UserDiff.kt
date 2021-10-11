package com.example.popular_libraries.presentation.userrepolist.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.popular_libraries.presentation.GitHubUserRepoViewModel

object UserDiff : DiffUtil.ItemCallback<GitHubUserRepoViewModel>() {

    private val payload = Any()

    override fun areItemsTheSame(
        oldItem: GitHubUserRepoViewModel,
        newItem: GitHubUserRepoViewModel,
    ): Boolean {
        return oldItem.name == newItem.name
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: GitHubUserRepoViewModel,
        newItem: GitHubUserRepoViewModel,
    ): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(
        oldItem: GitHubUserRepoViewModel,
        newItem: GitHubUserRepoViewModel,
    ) = payload

}
