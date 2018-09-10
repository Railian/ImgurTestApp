package ua.raylyan.imgurtestapp.platform.network.entity

import com.google.gson.annotations.SerializedName

internal data class ImgurJsonImage(
        @SerializedName("id") val id: String,
        @SerializedName("type") val type: String?,
        @SerializedName("width") val width: Int?,
        @SerializedName("height") val height: Int?,
        @SerializedName("link") val link: String?
)