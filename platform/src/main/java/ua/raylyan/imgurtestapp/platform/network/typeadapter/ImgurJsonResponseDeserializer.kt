package ua.raylyan.imgurtestapp.platform.network.typeadapter

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import ua.raylyan.imgurtestapp.platform.network.entity.ImgurJsonResponse
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

internal class ImgurJsonResponseDeserializer<T> : JsonDeserializer<ImgurJsonResponse<T>> {

    override fun deserialize(
            json: JsonElement,
            typeOfT: Type,
            context: JsonDeserializationContext
    ): ImgurJsonResponse<T> {
        val typeOfData = (typeOfT as ParameterizedType).actualTypeArguments.single()
        val typeOfResponse = when (json.asJsonObject.get("success").asBoolean) {
            true -> TypeToken.getParameterized(ImgurJsonResponse.Success::class.java, typeOfData).type
            false -> TypeToken.getParameterized(ImgurJsonResponse.Error::class.java, typeOfData).type
        }
        return context.deserialize(json, typeOfResponse)
    }
}