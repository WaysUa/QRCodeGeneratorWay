package com.main.generation_from_link.di.modules

import com.main.core.database.repository.QRCodeCacheRepository
import com.main.generation_from_link.domain.dialog.ManageGeneratedDialogFromLink
import com.main.generation_from_link.domain.usecase.GenerationFromLinkUseCase
import com.main.generation_from_link.presentation.communication.GenerationFromLinkCommunication
import com.main.generation_from_link.presentation.communication.GenerationFromLinkImageCommunication
import com.main.generation_from_link.presentation.viewmodel.GenerationFromLinkViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class GenerationFromLinkPresentationModule {

    @Provides
    fun provideGenerationFromTextViewModelFactory(
        generationFromLinkUseCase: GenerationFromLinkUseCase,
        generationFromTextCommunication: GenerationFromLinkCommunication,
        manageGeneratedDialogFromLink: ManageGeneratedDialogFromLink,
        qrCodeCacheRepository: QRCodeCacheRepository
    ): GenerationFromLinkViewModelFactory {
        return GenerationFromLinkViewModelFactory(
            generationFromLinkUseCase = generationFromLinkUseCase,
            generationFromLinkCommunication = generationFromTextCommunication,
            manageGeneratedDialogFromLink = manageGeneratedDialogFromLink,
            qrCodeCacheRepository = qrCodeCacheRepository
        )
    }

    @Provides
    fun provideGenerationFromTextCommunication(
        generationFromTextImageCommunication: GenerationFromLinkImageCommunication
    ): GenerationFromLinkCommunication {
        return GenerationFromLinkCommunication.Base(generationFromTextImageCommunication)
    }

    @Provides
    fun provideGenerationFormTextImageCommunication(): GenerationFromLinkImageCommunication {
        return GenerationFromLinkImageCommunication.Base()
    }
}