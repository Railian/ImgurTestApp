package ua.raylyan.imgurtestapp.domain.entity

data class Image(
        val id: String,
        val title: String?,
        val type: String,
        val width: Int,
        val height: Int,
        val link: String,
        val commentCount: Int
)