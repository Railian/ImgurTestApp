package ua.raylyan.imgurtestapp.domain.contract.datasource

import io.reactivex.Single
import ua.raylyan.imgurtestapp.domain.entity.Comment
import ua.raylyan.imgurtestapp.domain.entity.Image

interface ImageNetworkDataSource {
    fun searchImagesInGallery(query: String, page: Int = 1): Single<List<Image>>
    fun getComments(imageId: String): Single<List<Comment>>
}