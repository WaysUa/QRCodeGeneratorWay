package com.main.generation_from_text.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.main.core.base.BaseViewModelFactory
import com.main.core.database.repository.QRCodeCacheRepository
import com.main.generation_from_text.domain.dialog.ManageGeneratedDialogFromText
import com.main.generation_from_text.domain.usecase.GenerationFromTextUseCase
import com.main.generation_from_text.presentation.communication.GenerationFromTextCommunication

class GenerationFromTextViewModelFactory(
    private val generationFromTextUseCase: GenerationFromTextUseCase,
    private val generationFromTextCommunication: GenerationFromTextCommunication,
    private val manageGeneratedDialogFromText: ManageGeneratedDialogFromText,
    private val qrCodeCacheRepository: QRCodeCacheRepository
) : BaseViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GenerationFromTextViewModel(
            generationFromTextUseCase = generationFromTextUseCase,
            generationFromTextCommunication = generationFromTextCommunication,
            manageGeneratedDialogFromText = manageGeneratedDialogFromText,
            qrCodeCacheRepository = qrCodeCacheRepository
        ) as T
    }
}