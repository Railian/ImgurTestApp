package ua.raylyan.imgurtestapp.platform.network

import io.reactivex.Single
import ua.raylyan.imgurtestapp.platform.network.entity.ImgurJsonResponse

internal fun <T> Single<ImgurJsonResponse<T>>.mapImgurResponse(): Single<T> {
    return this.flatMap { response ->
        when (response) {
            is ImgurJsonResponse.Success -> Single.just(response.data)
            is ImgurJsonResponse.Error -> Single.error<T>(response.adapt())
        }
    }
}