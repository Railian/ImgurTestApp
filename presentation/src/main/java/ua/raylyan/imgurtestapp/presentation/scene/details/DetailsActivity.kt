package ua.raylyan.imgurtestapp.presentation.scene.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_gallery.*
import ua.raylyan.imgurtestapp.presentation.R
import ua.raylyan.imgurtestapp.presentation.scene.BaseActivity
import ua.raylyan.imgurtestapp.presentation.util.observe

class DetailsActivity : BaseActivity() {

    companion object {

        private const val EXTRA_IMAGE_ID = "extra:imageId"

        fun getIntent(context: Context, imageId: String): Intent {
            return Intent(context, DetailsActivity::class.java)
                    .putExtra(EXTRA_IMAGE_ID, imageId)
        }
    }

    private val viewModel by viewModelProvider<DetailsViewModel>()
    private val adapter = ImageDetailsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        viewModel.init(intent.getStringExtra(EXTRA_IMAGE_ID))
        observe(viewModel.image) { adapter.image = it }
        observe(viewModel.comments) { adapter.comments = it }
        observe(viewModel.errors) { Toast.makeText(this, it.message, Toast.LENGTH_LONG).show() }
        recyclerView.adapter = adapter
    }
}