package ua.raylyan.imgurtestapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ua.raylyan.imgurtestapp.di.util.ViewModelFactory
import ua.raylyan.imgurtestapp.di.util.ViewModelKey
import ua.raylyan.imgurtestapp.presentation.scene.details.DetailsViewModel
import ua.raylyan.imgurtestapp.presentation.scene.gallery.GalleryViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(GalleryViewModel::class)
    abstract fun bindGalleryViewModel(viewModel: GalleryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindDetailsViewModel(viewModel: DetailsViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}