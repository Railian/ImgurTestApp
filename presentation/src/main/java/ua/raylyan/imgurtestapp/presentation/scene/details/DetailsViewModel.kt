package ua.raylyan.imgurtestapp.presentation.scene.details

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import ua.raylyan.imgurtestapp.domain.contract.repository.ImageRepository
import ua.raylyan.imgurtestapp.domain.entity.Comment
import ua.raylyan.imgurtestapp.domain.entity.Image
import ua.raylyan.imgurtestapp.presentation.util.ReactiveViewModel
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
        private val repository: ImageRepository
) : ReactiveViewModel() {

    val image by liveData<Image>()
    val comments by liveData<List<Comment>>()
    val isLoading by liveData<Boolean>()
    val errors by singleLiveEvent<Throwable>()

    fun init(imageId: String) {

        repository.observeImage(imageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = { image.update(it) },
                        onError = { errors.update(it) }
                )
                .autoDispose()

        repository.loadComments(imageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoading.update(true) }
                .doOnSuccess { isLoading.update(false) }
                .subscribeBy(
                        onSuccess = { comments.update(it) },
                        onError = { errors.update(it) }
                )
                .autoDispose()
    }
}