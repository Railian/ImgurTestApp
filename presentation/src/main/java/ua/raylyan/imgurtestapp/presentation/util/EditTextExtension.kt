package ua.raylyan.imgurtestapp.presentation.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun EditText.onTextChanged(
        before: (s: CharSequence?, start: Int, count: Int, after: Int) -> Unit = { _, _, _, _ -> },
        during: (s: CharSequence?, start: Int, before: Int, count: Int) -> Unit = { _, _, _, _ -> },
        after: (s: Editable?) -> Unit = {}
): TextWatcher {
    return object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = before(s, start, count, after)
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = during(s, start, before, count)
        override fun afterTextChanged(s: Editable?) = after(s)
    }.also(::addTextChangedListener)
}