package ua.raylyan.imgurtestapp.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ua.raylyan.imgurtestapp.presentation.scene.details.DetailsActivity
import ua.raylyan.imgurtestapp.presentation.scene.gallery.GalleryActivity
import ua.raylyan.imgurtestapp.presentation.util.AndroidxSupportInjectionModule

@Module(includes = [AndroidxSupportInjectionModule::class])
interface ViewModule {

    @ContributesAndroidInjector
    fun galleryActivityInjector(): GalleryActivity

    @ContributesAndroidInjector
    fun detailsActivity(): DetailsActivity
}