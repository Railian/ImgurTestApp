package ua.raylyan.imgurtestapp.di.module

import dagger.Binds
import dagger.Module
import ua.raylyan.imgurtestapp.business.logic.repository.ImageRepositoryImpl
import ua.raylyan.imgurtestapp.domain.contract.repository.ImageRepository
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindImageRepository(repository: ImageRepositoryImpl): ImageRepository
}