package ua.raylyan.imgurtestapp.presentation.scene.details

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_gallery.view.*
import ua.raylyan.imgurtestapp.domain.entity.Image

class DetailsHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(image: Image) {
        with(Picasso.get()) {
            cancelRequest(itemView.imageView)
            load(image.link)
                    .resize(800, 0)
                    .placeholder(android.R.color.transparent)
                    .into(itemView.imageView)
        }
    }
}