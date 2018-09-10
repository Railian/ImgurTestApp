package ua.raylyan.imgurtestapp.presentation.scene.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.raylyan.imgurtestapp.domain.entity.Image
import ua.raylyan.imgurtestapp.presentation.R
import kotlin.properties.Delegates

class ImageAdapter : RecyclerView.Adapter<ImageViewHolder>() {

    var images: List<Image> by Delegates.observable(
            initialValue = emptyList(),
            onChange = { _, _, _ -> notifyDataSetChanged() }
    )

    override fun getItemCount(): Int = images.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_gallery, parent, false)
        return ImageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }

    fun onItemClick(action: () -> Unit) {

    }
}