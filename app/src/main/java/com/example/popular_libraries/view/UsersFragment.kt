package com.example.popular_libraries.view

import android.annotation.SuppressLint
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.popular_libraries.App.Navigation.router
import com.example.popular_libraries.R
import com.example.popular_libraries.databinding.FragmentUsersBinding
import com.example.popular_libraries.model.repo.GithubUsersRepoFactory
import com.example.popular_libraries.presenter.BackButtonListener
import com.example.popular_libraries.presenter.UsersPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), UsersView, BackButtonListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private val binding: FragmentUsersBinding by viewBinding()
    private val presenter by moxyPresenter {
        UsersPresenter(
            GithubUsersRepoFactory.create(),
                router)
    }
    private var adapter: UsersRVAdapter? = null

    override fun init() {
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        binding.rvUsers.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_LONG).show()
    }

    override fun backPressed() = presenter.backPressed()
}