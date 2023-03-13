package com.main.generate.presentation.viewmodel

import androidx.navigation.NavController
import com.main.core.base.BaseViewModel
import com.main.generate.domain.navigation.GenerationNavigation

class GenerationViewModel(
    private val generationNavigation: GenerationNavigation
) : BaseViewModel(), GenerationNavigation {

    override fun navigateToGenerationFromTextFragment(navController: NavController) {
        generationNavigation.navigateToGenerationFromTextFragment(navController)
    }

    override fun navigateToGenerationFromLinkFragment(navController: NavController) {
        generationNavigation.navigateToGenerationFromLinkFragment(navController)
    }
}