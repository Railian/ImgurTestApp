package ua.raylyan.imgurtestapp.presentation.util

import android.view.View

fun View.onClicked(action: () -> Unit) =
        setOnClickListener { action() }