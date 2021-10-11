package com.example.popular_libraries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.popular_libraries.databinding.FragmentUserBinding
import com.example.popular_libraries.model.GithubUser
import com.example.popular_libraries.presenter.BackButtonListener
import com.example.popular_libraries.presenter.UserPresenter
import com.example.popular_libraries.view.UserView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), UserView, BackButtonListener {

    private val vb: FragmentUserBinding by viewBinding()
    private val presenter: UserPresenter by moxyPresenter {
        val user = arguments?.getParcelable<GithubUser>(USER) as GithubUser
        UserPresenter(App.instance.router, user)
    }


    override fun setLogin(text: String) {
        vb.userLoginText.text = text
    }

    override fun backPressed() = presenter.backPressed()

    companion object {
        private const val USER = "USER"
        fun newInstance(user: GithubUser): Fragment =
            UserFragment().apply {
                arguments = bundleOf().apply {
                    putParcelable(USER, user)
                }
            }
    }
}