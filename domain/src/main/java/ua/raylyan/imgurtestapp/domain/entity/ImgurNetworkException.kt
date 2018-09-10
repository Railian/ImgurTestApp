package ua.raylyan.imgurtestapp.domain.entity

class ImgurNetworkException(
        override val message: String,
        val code: Int,
        val request: String,
        val method: String
) : RuntimeException(message)