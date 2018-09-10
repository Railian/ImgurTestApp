package ua.raylyan.imgurtestapp.domain.contract.datasource

import io.reactivex.Completable
import io.reactivex.Observable
import ua.raylyan.imgurtestapp.domain.entity.Image

interface ImageCacheDataSource {
    fun observeImages(): Observable<List<Image>>
    fun observeImage(imageId: String): Observable<Image>
    fun addImages(images: List<Image>): Completable
    fun removeAllImages(): Completable
}