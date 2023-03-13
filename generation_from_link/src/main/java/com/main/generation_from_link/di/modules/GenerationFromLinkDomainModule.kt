package com.main.generation_from_link.di.modules

import com.main.generation_from_link.domain.generation.GenerationFromLinkRepository
import com.main.generation_from_link.domain.usecase.GenerationFromLinkUseCase
import dagger.Module
import dagger.Provides

@Module
class GenerationFromLinkDomainModule {

    @Provides
    fun provideGenerationFromLink(): GenerationFromLinkRepository {
        return GenerationFromLinkRepository.Base()
    }

    @Provides
    fun provideGenerationFromLinkUseCase(
        generationFromLinkRepository: GenerationFromLinkRepository
    ): GenerationFromLinkUseCase {
        return GenerationFromLinkUseCase(generationFromLinkRepository)
    }
}