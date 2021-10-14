package com.example.popular_libraries.basic.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.popular_libraries.R
import com.example.popular_libraries.basic.listeners.BackButtonListener
import com.example.popular_libraries.data.db.StorageDB
import com.example.popular_libraries.data.entities.Setting
import com.example.popular_libraries.databinding.SettingFragmentBinding
import com.example.popular_libraries.di.BaseDaggerBottomSheetFragment
import com.example.popular_libraries.extensions.showToast
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class SettingFragment : BaseDaggerBottomSheetFragment(), SettingView, BackButtonListener {

    @Inject
    lateinit var settingPresenterFactory: SettingPresenterFactory

    companion object {
        private const val TAG = "SettingFragment"

        fun show(fragmentManager: FragmentManager) {
            SettingFragment().show(fragmentManager, TAG)
        }
    }

    private val binding: SettingFragmentBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val presenter by moxyPresenter { settingPresenterFactory.create() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) =
        binding.root

    override fun backPressed() = presenter.backPressed()

    override fun init() {
        buttonListener()

        binding.periodUpdateValue.value = StorageDB.PERIOD_UPDATE_DEFAULT.toFloat()
    }

    override fun startLoadData() {
        binding.progressBar.visibility = View.VISIBLE
        binding.settingData.visibility = View.GONE
    }

    override fun endLoadData() {
        binding.progressBar.visibility = View.GONE
        binding.settingData.visibility = View.VISIBLE
    }

    override fun showSettings(settings: List<Setting>) {
        settings.forEach { setting ->
            when (setting.settingName) {
                StorageDB.PARAM_PERIOD_UPDATE -> binding.periodUpdateValue.value =
                    setting.value.toFloat()
            }
        }
    }

    override fun showException(throwable: Throwable) {
        requireContext().showToast(throwable.message)
    }

    private fun buttonListener() {
        binding.periodUpdateValue.addOnChangeListener { _, value, _ ->
            val title = String.format(getString(R.string.period_update_text), value.toInt())
            binding.periodUpdateText.text = title
            presenter.savePeriodUpdate(value.toInt())
        }
    }
}