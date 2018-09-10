package ua.raylyan.imgurtestapp.domain.entity

data class Comment(
        val id: String,
        val author: String,
        val comment: String,
        val isDeleted: Boolean,
        val children: List<Comment>
)