package com.example.popular_libraries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.popular_libraries.databinding.FragmentUserBinding
import com.example.popular_libraries.model.GithubUser
import com.example.popular_libraries.presenter.BackButtonListener
import com.example.popular_libraries.presenter.UserPresenter
import com.example.popular_libraries.view.UserView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {

    private var vb: FragmentUserBinding? = null
    private val presenter: UserPresenter by moxyPresenter {
        val user = arguments?.getParcelable<GithubUser>(USER) as GithubUser
        UserPresenter(App.instance.router, user)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun setLogin(text: String) {
        vb?.userLoginText?.text = text
    }

    override fun backPressed() = presenter.backPressed()

    companion object {
        private const val USER = "USER"
        fun newInstance(user: GithubUser) =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(USER, user)
                }
            }
    }
}