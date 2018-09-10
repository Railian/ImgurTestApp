package ua.raylyan.imgurtestapp.presentation.scene.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.raylyan.imgurtestapp.domain.entity.Image
import ua.raylyan.imgurtestapp.presentation.R
import ua.raylyan.imgurtestapp.presentation.util.onClicked
import kotlin.properties.Delegates

class ImageAdapter : RecyclerView.Adapter<ImageViewHolder>() {

    var images: List<Image> by Delegates.observable(
            initialValue = emptyList(),
            onChange = { _, _, _ -> notifyDataSetChanged() }
    )

    private var onImageClickedAction: (item: Image) -> Unit = {}

    override fun getItemCount(): Int = images.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_gallery, parent, false)
        return ImageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = images[position]
        holder.bind(image)
        holder.itemView.onClicked { onImageClickedAction.invoke(image) }
    }

    fun onImageClicked(action: (item: Image) -> Unit) {
        onImageClickedAction = action
    }
}