package com.main.generation_from_text.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.main.core.base.BaseViewModelFactory
import com.main.generation_from_text.domain.generation.GenerationFromText

class GenerationFromTextViewModelFactory(
    private val generationFromText: GenerationFromText
) : BaseViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GenerationFromTextViewModel(
            generationFromText = generationFromText
        ) as T
    }
}