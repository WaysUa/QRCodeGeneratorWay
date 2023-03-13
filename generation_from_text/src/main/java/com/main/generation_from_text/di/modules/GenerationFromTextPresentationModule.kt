package com.main.generation_from_text.di.modules

import com.main.generation_from_text.domain.generation.GenerationFromTextRepository
import com.main.generation_from_text.presentation.viewmodel.GenerationFromTextViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class GenerationFromTextPresentationModule {

    @Provides
    fun provideGenerationFromTextViewModelFactory(
        generationFromTextRepository: GenerationFromTextRepository
    ): GenerationFromTextViewModelFactory {
        return GenerationFromTextViewModelFactory(generationFromTextRepository)
    }

}