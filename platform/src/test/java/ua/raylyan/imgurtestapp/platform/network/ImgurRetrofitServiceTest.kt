package ua.raylyan.imgurtestapp.platform.network

import org.junit.Test
import ua.raylyan.imgurtestapp.platform.network.entity.ImgurJsonResponse
import ua.raylyan.imgurtestapp.platform.network.service.ImgurRetrofitService

class ImgurRetrofitServiceTest {

    private val service = RetrofitFactory.imgurRetrofit.create(ImgurRetrofitService::class.java)

    @Test
    fun testGallerySearch() {
        service.gallerySearch(query = "cats", type = "jpg").test().apply {
            assertNoErrors()
            assertValueCount(1)
            assertValueAt(0) { it is ImgurJsonResponse.Success }
            assertComplete()
        }
    }

    @Test
    fun testGetComments() {
        service.getComments(galleryHash = "Spx2QBq").test().apply {
            assertNoErrors()
            assertValueCount(1)
            assertValueAt(0) { it is ImgurJsonResponse.Success }
            assertComplete()
        }
    }
}