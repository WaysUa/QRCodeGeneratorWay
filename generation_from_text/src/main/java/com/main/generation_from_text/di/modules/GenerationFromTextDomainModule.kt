package com.main.generation_from_text.di.modules

import com.main.generation_from_text.domain.generation.GenerationFromTextRepository
import com.main.generation_from_text.domain.usecase.GenerationFromTextUseCase
import dagger.Module
import dagger.Provides

@Module
class GenerationFromTextDomainModule {

    @Provides
    fun provideGenerationFromText(): GenerationFromTextRepository {
        return GenerationFromTextRepository.Base()
    }

    @Provides
    fun provideGenerationFromTextUseCase(
        generationFromTextRepository: GenerationFromTextRepository
    ): GenerationFromTextUseCase {
        return GenerationFromTextUseCase(generationFromTextRepository)
    }
}