package com.example.popular_libraries.baselogic.user

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.RequestOptions
import com.example.popular_libraries.baselogic.BackButtonListener
import com.example.popular_libraries.baselogic.userrepositories.RepositoryRVAdapter
import com.example.popular_libraries.data.entity.GithubUser
import com.example.popular_libraries.data.repositories.GithubUsersRepository
import com.example.popular_libraries.data.repositories.UserAvatarRepository
import com.example.popular_libraries.databinding.UserFragmentBinding
import com.example.popular_libraries.extentions.dp
import com.example.popular_libraries.extentions.showToast
import com.example.popular_libraries.helpers.di.BaseDaggerFragment
import com.example.popular_libraries.helpers.shedules.AppSchedulers
import com.github.terrakok.cicerone.Router
import moxy.ktx.moxyPresenter

import javax.inject.Inject

class UserFragment : BaseDaggerFragment(), UserView, BackButtonListener {

    companion object {
        const val USER_LOGIN = "userLogin"
        fun newInstance(userLogin: String): Fragment = UserFragment()
            .also {
                it.arguments = bundleOf(USER_LOGIN to userLogin)
            }
    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var appSchedulers: AppSchedulers

    @Inject
    lateinit var githubUsersRepository: GithubUsersRepository

    @Inject
    lateinit var userAvatarRepository: UserAvatarRepository

    private val userLogin by lazy { arguments?.getString(USER_LOGIN) }
    private val binding: UserFragmentBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private var adapter: RepositoryRVAdapter? = null

    private val presenter by moxyPresenter {
        UserPresenter(
            githubUsersRepository,
            appSchedulers,
            userAvatarRepository,
            router,
            RepositoryListPresenter(),
            userLogin
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) =
        binding.root

    override fun init() {
        with(binding) {
            recyclerRepo.layoutManager = LinearLayoutManager(context)
            adapter = RepositoryRVAdapter(presenter.repositoryListPresenter)
            recyclerRepo.adapter = adapter
            recyclerRepo.itemAnimator = DefaultItemAnimator()
            recyclerRepo.addItemDecoration(DividerItemDecoration(context,
                LinearLayoutManager.VERTICAL))
        }
    }

    override fun showUser(user: GithubUser, requestBuilder: RequestBuilder<Drawable>) {
        binding.loginText.text = user.login

        requestBuilder
            .apply(
                RequestOptions
                    .circleCropTransform()
                    .override(140.dp(requireContext()))
            )
            .into(binding.avatarId)
    }

    override fun updateRepositoryList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showException(throwable: Throwable) {
        context?.showToast(throwable.message)
    }

    override fun backPressed() = presenter.backPressed()
}