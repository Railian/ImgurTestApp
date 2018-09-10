package ua.raylyan.imgurtestapp.di.component

import dagger.Component
import dagger.android.AndroidInjector
import ua.raylyan.imgurtestapp.di.ImgurTestApplication
import ua.raylyan.imgurtestapp.di.module.*
import javax.inject.Singleton

@Component(modules = [
    DataSourceModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    ViewModelModule::class,
    ViewModule::class
])
@Singleton
interface AppComponent : AndroidInjector<ImgurTestApplication>