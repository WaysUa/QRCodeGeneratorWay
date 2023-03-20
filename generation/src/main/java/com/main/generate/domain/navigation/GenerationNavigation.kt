package com.main.generate.domain.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.main.core.navigation.DeepLinks
import com.main.generate.R

interface GenerationNavigation {

    fun navigateToGenerationFromTextFragment(navController: NavController)

    fun navigateToGenerationFromLinkFragment(navController: NavController)

    fun navigateToGenerationFromPhoneFragment(navController: NavController)

    fun navigateToFavoritesFragment(navController: NavController)

    class Base : GenerationNavigation {

        override fun navigateToGenerationFromTextFragment(navController: NavController) {
            navController.navigate(DeepLinks.GENERATION_FROM_TEXT_DEEP_LINK)
        }

        override fun navigateToGenerationFromLinkFragment(navController: NavController) {
            navController.navigate(DeepLinks.GENERATION_FROM_LINK_DEEP_LINK)
        }

        override fun navigateToGenerationFromPhoneFragment(navController: NavController) {
            navController.navigate(DeepLinks.GENERATION_FROM_PHONE_DEEP_LINK)
        }

        override fun navigateToFavoritesFragment(navController: NavController) {
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.generationNavGraph, true).build()
            navController.navigate(DeepLinks.FAVORITES_DEEP_LINK, navOptions)
        }
    }
}