package com.example.popular_libraries.baselogic.userrepositories

interface RepositoryItemView {
    var currentPosition: Int

    fun setName(text: String)
}