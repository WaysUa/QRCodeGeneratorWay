package com.main.generation_from_text.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.main.core.base.BaseViewModelFactory
import com.main.generation_from_text.domain.dialog.ManageGeneratedDialogFromText
import com.main.generation_from_text.domain.generation.GenerationFromTextRepository
import com.main.generation_from_text.domain.usecase.GenerationFromTextUseCase
import com.main.generation_from_text.presentation.communication.GenerationFromTextCommunication

class GenerationFromTextViewModelFactory(
    private val generationFromTextUseCase: GenerationFromTextUseCase,
    private val generationFromTextCommunication: GenerationFromTextCommunication,
    private val manageGeneratedDialogFromText: ManageGeneratedDialogFromText
) : BaseViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GenerationFromTextViewModel(
            generationFromTextUseCase = generationFromTextUseCase,
            generationFromTextCommunication = generationFromTextCommunication,
            manageGeneratedDialogFromText = manageGeneratedDialogFromText
        ) as T
    }
}