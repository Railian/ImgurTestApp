package ua.raylyan.imgurtestapp.platform.network.service

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ua.raylyan.imgurtestapp.platform.network.ImgurJsonResponse
import ua.raylyan.imgurtestapp.platform.network.entity.ImgurJsonComment
import ua.raylyan.imgurtestapp.platform.network.entity.ImgurJsonGalleryItem

internal interface ImgurRetrofitService {

    @GET("/3/gallery/search/{page}")
    fun gallerySearch(
            @Path("page") page: Int = 1,
            @Query("q") query: String,
            @Query("q_type") type: String
    ): Single<ImgurJsonResponse<List<ImgurJsonGalleryItem>>>

    @GET("/3/gallery/{gallery_hash}/comments/")
    fun getComments(
            @Path("gallery_hash") galleryHash: String
    ): Single<ImgurJsonResponse<List<ImgurJsonComment>>>
}