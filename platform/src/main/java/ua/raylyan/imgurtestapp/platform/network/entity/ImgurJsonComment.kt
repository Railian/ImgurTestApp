package ua.raylyan.imgurtestapp.platform.network.entity

import com.google.gson.annotations.SerializedName

internal data class ImgurJsonComment(
        @SerializedName("id") val id: String,
        @SerializedName("image_id") val imageId: String,
        @SerializedName("author") val author: String,
        @SerializedName("author_id") val authorId: Long,
        @SerializedName("comment") val comment: String,
        @SerializedName("deleted") val isDeleted: Boolean,
        @SerializedName("platform") val platform: String,
        @SerializedName("children") val children: List<ImgurJsonComment>
)