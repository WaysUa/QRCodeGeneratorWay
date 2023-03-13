package com.main.generate.domain.navigation

import androidx.navigation.NavController
import com.main.core.navigation.DeepLinks

interface GenerationNavigation {

    fun navigateToGenerationFromTextFragment(navController: NavController)

    fun navigateToGenerationFromLinkFragment(navController: NavController)

    class Base : GenerationNavigation {

        override fun navigateToGenerationFromTextFragment(navController: NavController) {
            navController.navigate(DeepLinks.GENERATION_FROM_TEXT_DEEP_LINK)
        }

        override fun navigateToGenerationFromLinkFragment(navController: NavController) {
            navController.navigate(DeepLinks.GENERATION_FROM_LINK_DEEP_LINK)
        }
    }
}