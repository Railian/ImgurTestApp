package ua.raylyan.imgurtestapp.platform.network.entity

import com.google.gson.annotations.SerializedName

internal data class ImgurJsonGalleryItem(
        @SerializedName("id") val id: String,
        @SerializedName("title") val title: String?,
        @SerializedName("comment_count") val commentCount: Int?,
        @SerializedName("images") val images: List<ImgurJsonImage>?
)