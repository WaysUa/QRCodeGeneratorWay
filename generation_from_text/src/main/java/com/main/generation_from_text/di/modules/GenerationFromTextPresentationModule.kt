package com.main.generation_from_text.di.modules

import com.main.core.database.repository.QRCodeCacheRepository
import com.main.generation_from_text.domain.dialog.ManageGeneratedDialogFromText
import com.main.generation_from_text.domain.usecase.GenerationFromTextUseCase
import com.main.generation_from_text.presentation.communication.GenerationFromTextCommunication
import com.main.generation_from_text.presentation.communication.GenerationFromTextImageCommunication
import com.main.generation_from_text.presentation.viewmodel.GenerationFromTextViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class GenerationFromTextPresentationModule {

    @Provides
    fun provideGenerationFromTextViewModelFactory(
        generationFromTextUseCase: GenerationFromTextUseCase,
        generationFromTextCommunication: GenerationFromTextCommunication,
        manageGeneratedDialogFromText: ManageGeneratedDialogFromText,
        qrCodeCacheRepository: QRCodeCacheRepository
    ): GenerationFromTextViewModelFactory {
        return GenerationFromTextViewModelFactory(
            generationFromTextUseCase = generationFromTextUseCase,
            generationFromTextCommunication = generationFromTextCommunication,
            manageGeneratedDialogFromText = manageGeneratedDialogFromText,
            qrCodeCacheRepository = qrCodeCacheRepository
        )
    }

    @Provides
    fun provideGenerationFromTextCommunication(
        generationFromTextImageCommunication: GenerationFromTextImageCommunication
    ): GenerationFromTextCommunication {
        return GenerationFromTextCommunication.Base(generationFromTextImageCommunication)
    }

    @Provides
    fun provideGenerationFromTextImageCommunication(): GenerationFromTextImageCommunication {
        return GenerationFromTextImageCommunication.Base()
    }
}