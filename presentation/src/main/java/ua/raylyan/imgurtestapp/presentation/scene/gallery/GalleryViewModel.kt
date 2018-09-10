package ua.raylyan.imgurtestapp.presentation.scene.gallery

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import ua.raylyan.imgurtestapp.domain.contract.repository.ImageRepository
import ua.raylyan.imgurtestapp.domain.entity.Image
import ua.raylyan.imgurtestapp.presentation.util.ReactiveViewModel
import javax.inject.Inject

class GalleryViewModel @Inject constructor(
        private val repository: ImageRepository
) : ReactiveViewModel() {

    val searchResult by liveData<List<Image>>()
    val isLoading by liveData<Boolean>()
    val errors by singleLiveEvent<Throwable>()

    private val loadingDisposable by disposable()

    init {
        repository.observeSearchResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = { searchResult.update(it) },
                        onError = { errors.update(it) }
                )
                .autoDispose()
    }

    fun searchImage(query: String) {
        loadingDisposable.dispose()
        repository.searchInGallery(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoading.update(true) }
                .doOnComplete { isLoading.update(false) }
                .subscribeBy(onError = { errors.update(it) })
                .addTo(loadingDisposable)
                .autoDispose()
    }

    fun loadNextPage() {
        loadingDisposable.dispose()
        repository.loadNextPage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoading.update(true) }
                .doOnComplete { isLoading.update(false) }
                .subscribeBy(onError = { errors.update(it) })
                .addTo(loadingDisposable)
                .autoDispose()
    }
}