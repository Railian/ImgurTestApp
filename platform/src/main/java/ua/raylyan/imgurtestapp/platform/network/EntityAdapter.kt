package ua.raylyan.imgurtestapp.platform.network

import ua.raylyan.imgurtestapp.domain.entity.Comment
import ua.raylyan.imgurtestapp.domain.entity.Image
import ua.raylyan.imgurtestapp.domain.entity.ImgurNetworkException
import ua.raylyan.imgurtestapp.platform.network.entity.ImgurJsonComment
import ua.raylyan.imgurtestapp.platform.network.entity.ImgurJsonGalleryItem
import ua.raylyan.imgurtestapp.platform.network.entity.ImgurJsonResponse

internal fun ImgurJsonGalleryItem.adapt(): Image {
    val image = this.images
            ?.find { it.type == "image/png" || it.type == "image/jpeg" }
            ?: throw RuntimeException("there were no any images with mime type \"image/png\" or \"image/jpeg\"")
    image.type ?: throw NullPointerException("type of image is required")
    image.link ?: throw NullPointerException("link of image is required")
    return Image(
            id = id,
            title = title,
            type = image.type,
            width = image.width ?: 0,
            height = image.height ?: 0,
            link = image.link,
            commentCount = commentCount ?: 0
    )
}

internal fun ImgurJsonComment.adapt(): Comment {
    return Comment(
            id = id,
            author = author,
            text = comment,
            isDeleted = isDeleted,
            children = children.map { it.adapt() }
    )
}

internal fun <T> ImgurJsonResponse.Error<T>.adapt(): ImgurNetworkException {
    return ImgurNetworkException(
            message = errorDetails.error,
            code = status,
            request = errorDetails.request,
            method = errorDetails.method
    )
}