package ua.raylyan.imgurtestapp.presentation.util

import android.view.View

fun View.onClick(action: () -> Unit) =
        setOnClickListener { action() }