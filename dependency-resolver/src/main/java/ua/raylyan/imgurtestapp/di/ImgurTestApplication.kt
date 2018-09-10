package ua.raylyan.imgurtestapp.di

import dagger.android.AndroidInjector
import ua.raylyan.imgurtestapp.di.component.DaggerAppComponent
import ua.raylyan.imgurtestapp.presentation.util.DaggerxApplication

class ImgurTestApplication : DaggerxApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerxApplication> = DaggerAppComponent.create()
}