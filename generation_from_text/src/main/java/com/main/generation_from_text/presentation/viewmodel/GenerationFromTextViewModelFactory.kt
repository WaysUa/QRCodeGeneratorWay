package com.main.generation_from_text.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.main.core.base.BaseViewModelFactory
import com.main.generation_from_text.domain.generation.GenerationFromTextRepository

class GenerationFromTextViewModelFactory(
    private val generationFromTextRepository: GenerationFromTextRepository
) : BaseViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GenerationFromTextViewModel(
            generationFromTextRepository = generationFromTextRepository
        ) as T
    }
}