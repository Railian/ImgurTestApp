package ua.raylyan.imgurtestapp.domain.contract.repository

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ua.raylyan.imgurtestapp.domain.entity.Comment
import ua.raylyan.imgurtestapp.domain.entity.Image

interface ImageRepository {
    fun observeSearchResult(): Observable<List<Image>>
    fun searchInGallery(query: String): Completable
    fun loadNextPage(): Completable
    fun loadComments(imageId: String): Single<List<Comment>>
}