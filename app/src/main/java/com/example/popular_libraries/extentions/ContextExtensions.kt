package com.example.popular_libraries.extentions

import android.content.Context
import android.widget.Toast

fun Context.showToast(text: String?) {
    text?.let { Toast.makeText(this, text, Toast.LENGTH_LONG).show() }
}