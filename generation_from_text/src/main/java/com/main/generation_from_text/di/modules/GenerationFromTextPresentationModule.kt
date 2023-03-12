package com.main.generation_from_text.di.modules

import com.main.generation_from_text.domain.generation.GenerationFromText
import com.main.generation_from_text.presentation.viewmodel.GenerationFromTextViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class GenerationFromTextPresentationModule {

    @Provides
    fun provideGenerationFromTextViewModelFactory(
        generationFromText: GenerationFromText
    ): GenerationFromTextViewModelFactory {
        return GenerationFromTextViewModelFactory(generationFromText)
    }

}