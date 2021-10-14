package com.example.popular_libraries.basic.quote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.popular_libraries.R
import com.example.popular_libraries.basic.listeners.BackButtonListener
import com.example.popular_libraries.basic.setting.SettingFragment
import com.example.popular_libraries.data.entities.Quote
import com.example.popular_libraries.databinding.QuoteFragmentBinding
import com.example.popular_libraries.di.BaseDaggerFragment
import com.example.popular_libraries.extensions.hide
import com.example.popular_libraries.extensions.show
import com.example.popular_libraries.extensions.showToast
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class QuoteFragment : BaseDaggerFragment(), QuoteView, BackButtonListener {

    @Inject
    lateinit var quotePresenterFactory: QuotePresenterFactory

    companion object {
        fun newInstance(): Fragment = QuoteFragment()
    }

    private lateinit var binding: QuoteFragmentBinding
    private val presenter by moxyPresenter { quotePresenterFactory.create() }
    private var visibleSubmenu = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = QuoteFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun init() {
        buttonListener()
    }

    override fun backPressed() = presenter.backPressed()

    override fun startUpdateQuote() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun endUpdateQuote() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    override fun showQuote(quote: Quote) {
        binding.quoteText.hide()
        binding.quoteAuthor.hide()

        binding.quoteText.text = quote.quoteText
        binding.quoteAuthor.text = quote.quoteAuthor

        binding.quoteText.show()
        binding.quoteAuthor.show()
    }

    override fun showReverseTimer(value: Int) {
        val text = String.format(getString(R.string.reverse_timer_text), value)
        binding.reverseTimerText.text = text
    }

    override fun showException(throwable: Throwable) {
        requireContext().showToast(throwable.message)
    }

    private fun buttonListener() {
        binding.fabMenu.setOnClickListener {
            showOrHideFabMenu()
        }

        binding.fabHistoryQuote.setOnClickListener {
            presenter.openHistory()
            showOrHideFabMenu()
        }

        binding.fabSetting.setOnClickListener {
            SettingFragment.show(fragmentManager = childFragmentManager)
            showOrHideFabMenu()
        }

        binding.fabUpdateQuote.setOnClickListener {
            presenter.updateQuote()
            showOrHideFabMenu()
        }
    }

    private fun showOrHideFabMenu() {
        if (visibleSubmenu) {
            binding.fabHistoryQuote.visibility = View.GONE
            binding.fabSetting.visibility = View.GONE
            binding.fabUpdateQuote.visibility = View.GONE
        } else {
            binding.fabHistoryQuote.visibility = View.VISIBLE
            binding.fabSetting.visibility = View.VISIBLE
            binding.fabUpdateQuote.visibility = View.VISIBLE
        }
        visibleSubmenu = !visibleSubmenu
    }
}