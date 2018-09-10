package ua.raylyan.imgurtestapp.platform.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

internal object RetrofitFactory {

    private const val IMGUR_BASE_URL = "https://api.imgur.com"

    private val imgurAuthInterceptor = Interceptor {
        it.request().newBuilder()
                .addHeader("Authorization", "Client-ID ${ImgurConstants.CLIENT_ID}")
                .build()
                .let(it::proceed)
    }

    private val imgurClient = OkHttpClient.Builder()
            .addInterceptor(imgurAuthInterceptor)
            .build()

    internal val imgurRetrofit = Retrofit.Builder()
            .baseUrl(IMGUR_BASE_URL)
            .client(imgurClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
}