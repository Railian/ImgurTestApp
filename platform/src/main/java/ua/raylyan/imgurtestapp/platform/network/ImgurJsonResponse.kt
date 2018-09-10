package ua.raylyan.imgurtestapp.platform.network

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import ua.raylyan.imgurtestapp.platform.network.typeadapter.ImgurJsonResponseDeserializer

@JsonAdapter(ImgurJsonResponseDeserializer::class)
internal sealed class ImgurJsonResponse<T> {

    internal data class Success<T>(
            @SerializedName("data") val data: T
    ) : ImgurJsonResponse<T>()

    internal data class Error<T>(
            @SerializedName("status") val status: Int,
            @SerializedName("data") val details: Details
    ) : ImgurJsonResponse<T>() {

        internal data class Details(
                @SerializedName("error") val error: String,
                @SerializedName("request") val request: String,
                @SerializedName("method") val method: String
        )
    }
}