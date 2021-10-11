package com.example.popular_libraries.baselogic.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.popular_libraries.baselogic.BackButtonListener
import com.example.popular_libraries.data.repositories.GithubUsersRepository
import com.example.popular_libraries.data.repositories.UserAvatarRepository
import com.example.popular_libraries.databinding.UsersFragmentBinding
import com.example.popular_libraries.extentions.showToast
import com.example.popular_libraries.helpers.di.BaseDaggerFragment
import com.example.popular_libraries.helpers.shedules.AppSchedulers
import com.github.terrakok.cicerone.Router
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class UsersFragment : BaseDaggerFragment(), UsersView, BackButtonListener {

    companion object {
        fun newInstance(): Fragment = UsersFragment()
    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var appSchedulers: AppSchedulers

    @Inject
    lateinit var githubUsersRepository: GithubUsersRepository

    @Inject
    lateinit var userAvatarRepository: UserAvatarRepository

    private val binding: UsersFragmentBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val presenter by moxyPresenter {
        UsersPresenter(
            githubUsersRepository,
            appSchedulers,
            router)
    }
    private var adapter: UsersRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        initListeners()
        return binding.root
    }

    override fun init() {
        with(binding) {
            rvUsers.layoutManager = LinearLayoutManager(context)
            adapter = UsersRVAdapter(
                presenter.usersListPresenter,
                userAvatarRepository
            )
            rvUsers.adapter = adapter
            rvUsers.itemAnimator = DefaultItemAnimator()
            rvUsers.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showException(throwable: Throwable) {
        context?.showToast(throwable.message)
    }

    override fun backPressed() = presenter.backPressed()

    private fun initListeners() {
        binding.fabPicture.setOnClickListener { presenter.openWinImageCompressor() }
    }
}