package ua.raylyan.imgurtestapp.business.logic.repository

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ua.raylyan.imgurtestapp.domain.contract.datasource.ImageCacheDataSource
import ua.raylyan.imgurtestapp.domain.contract.datasource.ImageNetworkDataSource
import ua.raylyan.imgurtestapp.domain.contract.repository.ImageRepository
import ua.raylyan.imgurtestapp.domain.entity.Comment
import ua.raylyan.imgurtestapp.domain.entity.Image
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
        private val network: ImageNetworkDataSource,
        private val cache: ImageCacheDataSource
) : ImageRepository {

    private var lastQuery: String? = null
    private var loadedPages: Int = 0

    override fun observeSearchResult(): Observable<List<Image>> {
        return cache.observeImages()
    }

    override fun observeImage(imageId: String): Observable<Image> {
        return cache.observeImage(imageId)
    }

    override fun searchInGallery(query: String): Completable {
        return network.searchImagesInGallery(query)
                .flatMapCompletable {
                    cache.removeAllImages().andThen(cache.addImages(it))
                }
                .doOnComplete {
                    lastQuery = query
                    loadedPages = 1
                }
    }

    override fun loadNextPage(): Completable {
        val query = lastQuery
        return when (query) {
            null -> Completable.error(NullPointerException("There were no queries"))
            else -> network.searchImagesInGallery(query, loadedPages + 1)
                    .flatMapCompletable { cache.removeAllImages().andThen(cache.addImages(it)) }
                    .doOnComplete { loadedPages += 1 }
        }
    }

    override fun loadComments(imageId: String): Single<List<Comment>> {
        return network.getComments(imageId)
    }
}