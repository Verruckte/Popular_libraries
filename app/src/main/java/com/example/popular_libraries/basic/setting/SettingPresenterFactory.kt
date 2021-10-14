package com.example.popular_libraries.basic.setting

import dagger.assisted.AssistedFactory

@AssistedFactory
interface SettingPresenterFactory {
    fun create(): SettingPresenter
}