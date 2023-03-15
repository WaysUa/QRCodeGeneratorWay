package com.main.generation_from_phone.di.modules

import com.main.generation_from_phone.domain.generation.GenerationFromPhoneRepository
import com.main.generation_from_phone.domain.usecase.GenerationFromPhoneUseCase
import dagger.Module
import dagger.Provides

@Module
class GenerationFromPhoneDomainModule {

    @Provides
    fun provideGenerationFromPhone(): GenerationFromPhoneRepository {
        return GenerationFromPhoneRepository.Base()
    }

    @Provides
    fun provideGenerationFromTextUseCase(
        generationFromPhoneRepository: GenerationFromPhoneRepository
    ): GenerationFromPhoneUseCase {
        return GenerationFromPhoneUseCase(generationFromPhoneRepository)
    }
}