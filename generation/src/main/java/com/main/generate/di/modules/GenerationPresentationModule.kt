package com.main.generate.di.modules

import com.main.generate.domain.navigation.GenerationNavigation
import com.main.generate.presentation.viewmodel.GenerationViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class GenerationPresentationModule {

    @Provides
    fun provideGenerationViewModelFactory(
        generationNavigation: GenerationNavigation
    ): GenerationViewModelFactory {
        return GenerationViewModelFactory(generationNavigation)
    }

}