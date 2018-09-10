package ua.raylyan.imgurtestapp.di.module

import dagger.Module
import ua.raylyan.imgurtestapp.presentation.util.AndroidxSupportInjectionModule

@Module(includes = [AndroidxSupportInjectionModule::class])
interface ViewModule