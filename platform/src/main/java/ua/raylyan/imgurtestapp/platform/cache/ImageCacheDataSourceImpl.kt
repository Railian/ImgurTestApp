package ua.raylyan.imgurtestapp.platform.cache

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import ua.raylyan.imgurtestapp.domain.contract.datasource.ImageCacheDataSource
import ua.raylyan.imgurtestapp.domain.entity.Image

class ImageCacheDataSourceImpl : ImageCacheDataSource {

    private val cachedImages: BehaviorSubject<List<Image>> = BehaviorSubject.create()

    override fun observeImages(): Observable<List<Image>> {
        return cachedImages
    }

    override fun addImages(images: List<Image>): Completable {
        return Completable.fromCallable {
            val alreadyCachedImages = cachedImages.value ?: emptyList()
            cachedImages.onNext(alreadyCachedImages + images)
        }
    }

    override fun removeAllImages(): Completable {
        return Completable.fromCallable { cachedImages.onNext(emptyList()) }
    }
}