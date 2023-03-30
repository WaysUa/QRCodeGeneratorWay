package com.main.generation_from_phone.di.modules

import com.main.core.database.repository.QRCodeCacheRepository
import com.main.generation_from_phone.domain.dialog.ManageGeneratedDialogFromPhone
import com.main.generation_from_phone.domain.usecase.GenerationFromPhoneUseCase
import com.main.generation_from_phone.presentation.communication.GenerationFromPhoneCommunication
import com.main.generation_from_phone.presentation.communication.GenerationFromPhoneImageCommunication
import com.main.generation_from_phone.presentation.viewmodel.GenerationFromPhoneViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class GenerationFromPhonePresentationModule {

    @Provides
    fun provideGenerationFromPhoneViewModelFactory(
        generationFromPhoneUseCase: GenerationFromPhoneUseCase,
        generationFromPhoneCommunication: GenerationFromPhoneCommunication,
        manageGeneratedDialogFromPhone: ManageGeneratedDialogFromPhone,
        qrCodeCacheRepository: QRCodeCacheRepository
    ): GenerationFromPhoneViewModelFactory {
        return GenerationFromPhoneViewModelFactory(
            generationFromPhoneUseCase = generationFromPhoneUseCase,
            generationFromPhoneCommunication = generationFromPhoneCommunication,
            manageGeneratedDialogFromPhone = manageGeneratedDialogFromPhone,
            qrCodeCacheRepository = qrCodeCacheRepository
        )
    }

    @Provides
    fun provideGenerationFromPhoneCommunication(
        generationFromPhoneImageCommunication: GenerationFromPhoneImageCommunication
    ): GenerationFromPhoneCommunication {
        return GenerationFromPhoneCommunication.Base(generationFromPhoneImageCommunication)
    }

    @Provides
    fun provideGenerationFromPhoneImageCommunication(): GenerationFromPhoneImageCommunication {
        return GenerationFromPhoneImageCommunication.Base()
    }
}