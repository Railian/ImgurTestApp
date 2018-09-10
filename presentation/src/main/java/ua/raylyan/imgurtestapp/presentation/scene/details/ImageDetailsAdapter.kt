package ua.raylyan.imgurtestapp.presentation.scene.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.raylyan.imgurtestapp.domain.entity.Comment
import ua.raylyan.imgurtestapp.domain.entity.Image
import ua.raylyan.imgurtestapp.presentation.R
import kotlin.properties.Delegates

class ImageDetailsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_HEADER = 1
        private const val VIEW_TYPE_COMMENT = 2
    }

    var image: Image? by Delegates.observable<Image?>(
            initialValue = null,
            onChange = { _, _, _ -> notifyItemChanged(0) }
    )

    var comments: List<Comment>  by Delegates.observable(
            initialValue = emptyList(),
            onChange = { _, _, _ -> notifyDataSetChanged() }
    )

    override fun getItemCount(): Int = 1 + comments.count()

    override fun getItemViewType(position: Int): Int = when (position) {
        0 -> VIEW_TYPE_HEADER
        else -> VIEW_TYPE_COMMENT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                val itemView = inflater.inflate(R.layout.item_details_header, parent, false)
                DetailsHeaderViewHolder(itemView)
            }
            VIEW_TYPE_COMMENT -> {
                val itemView = inflater.inflate(R.layout.item_details_comment, parent, false)
                DetailsCommentViewHolder(itemView)
            }
            else -> throw IllegalArgumentException("Unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DetailsHeaderViewHolder -> image?.let(holder::bind)
            is DetailsCommentViewHolder -> holder.bind(comments[position - 1])
        }
    }
}