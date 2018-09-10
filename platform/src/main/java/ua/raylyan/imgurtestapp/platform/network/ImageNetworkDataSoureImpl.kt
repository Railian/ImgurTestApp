package ua.raylyan.imgurtestapp.platform.network

import io.reactivex.Single
import ua.raylyan.imgurtestapp.domain.contract.datasource.ImageNetworkDataSource
import ua.raylyan.imgurtestapp.domain.entity.Comment
import ua.raylyan.imgurtestapp.domain.entity.Image
import ua.raylyan.imgurtestapp.domain.util.tryOrNull
import ua.raylyan.imgurtestapp.platform.network.service.ImgurRetrofitService

class ImageNetworkDataSoureImpl : ImageNetworkDataSource {

    private val service = RetrofitFactory.imgurRetrofit.create(ImgurRetrofitService::class.java)

    override fun searchImagesInGallery(query: String, page: Int): Single<List<Image>> {
        return service.gallerySearch(query = query, type = "jpg", page = page)
                .mapImgurResponse()
                .map { list -> list.mapNotNull { tryOrNull { it.adapt() } } }
    }

    override fun getComments(imageId: String): Single<List<Comment>> {
        return service.getComments(imageId)
                .mapImgurResponse()
                .map { list -> list.map { it.adapt() } }
    }
}