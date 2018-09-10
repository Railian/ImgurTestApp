package ua.raylyan.imgurtestapp.presentation.scene.gallery

import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_gallery.*
import ua.raylyan.imgurtestapp.presentation.R
import ua.raylyan.imgurtestapp.presentation.scene.BaseActivity
import ua.raylyan.imgurtestapp.presentation.util.observe
import ua.raylyan.imgurtestapp.presentation.util.onTextChanged

class GalleryActivity : BaseActivity() {

    private val viewModel by viewModelProvider<GalleryViewModel>()
    private val adapter = ImageAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        observe(viewModel.searchResult) { adapter.images = it }
        observe(viewModel.errors) { Toast.makeText(this, it.message, Toast.LENGTH_LONG).show() }
        editTextSearch.onTextChanged { viewModel.searchImage(it.toString()) }
        recyclerView.adapter = adapter
    }
}