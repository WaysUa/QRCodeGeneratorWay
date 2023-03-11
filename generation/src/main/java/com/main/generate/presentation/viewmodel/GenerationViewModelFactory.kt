package com.main.generate.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.main.core.base.BaseViewModelFactory
import com.main.generate.domain.navigation.GenerationNavigation

class GenerationViewModelFactory(
    private val generationNavigation: GenerationNavigation
) : BaseViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GenerationViewModel(generationNavigation) as T
    }
}