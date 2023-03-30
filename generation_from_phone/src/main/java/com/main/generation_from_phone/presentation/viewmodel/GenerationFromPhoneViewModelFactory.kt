package com.main.generation_from_phone.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.main.core.base.BaseViewModelFactory
import com.main.core.database.repository.QRCodeCacheRepository
import com.main.generation_from_phone.domain.dialog.ManageGeneratedDialogFromPhone
import com.main.generation_from_phone.domain.usecase.GenerationFromPhoneUseCase
import com.main.generation_from_phone.presentation.communication.GenerationFromPhoneCommunication

class GenerationFromPhoneViewModelFactory(
    private val generationFromPhoneUseCase: GenerationFromPhoneUseCase,
    private val generationFromPhoneCommunication: GenerationFromPhoneCommunication,
    private val manageGeneratedDialogFromPhone: ManageGeneratedDialogFromPhone,
    private val qrCodeCacheRepository: QRCodeCacheRepository
) : BaseViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GenerationFromPhoneViewModel(
            generationFromPhoneUseCase = generationFromPhoneUseCase,
            generationFromPhoneCommunication = generationFromPhoneCommunication,
            manageGeneratedDialogFromPhone = manageGeneratedDialogFromPhone,
            qrCodeCacheRepository = qrCodeCacheRepository
        ) as T
    }
}