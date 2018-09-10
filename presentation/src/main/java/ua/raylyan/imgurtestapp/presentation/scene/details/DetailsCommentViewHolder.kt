package ua.raylyan.imgurtestapp.presentation.scene.details

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_details_comment.view.*
import ua.raylyan.imgurtestapp.domain.entity.Comment

class DetailsCommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(comment: Comment) {
        itemView.textViewAuthor.text = comment.author
        itemView.textViewComment.text = comment.text
    }
}