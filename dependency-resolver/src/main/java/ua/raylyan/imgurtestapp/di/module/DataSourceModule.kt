package ua.raylyan.imgurtestapp.di.module

import dagger.Binds
import dagger.Module
import ua.raylyan.imgurtestapp.domain.contract.datasource.ImageCacheDataSource
import ua.raylyan.imgurtestapp.domain.contract.datasource.ImageNetworkDataSource
import ua.raylyan.imgurtestapp.platform.cache.ImageCacheDataSourceImpl
import ua.raylyan.imgurtestapp.platform.network.ImageNetworkDataSourceImpl
import javax.inject.Singleton

@Module
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindImageNetworkDataSource(dataSource: ImageNetworkDataSourceImpl): ImageNetworkDataSource

    @Binds
    @Singleton
    abstract fun bindImageCacheDataSource(dataSource: ImageCacheDataSourceImpl): ImageCacheDataSource
}