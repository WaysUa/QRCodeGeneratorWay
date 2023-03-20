package com.main.favorites.domain.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.main.core.navigation.DeepLinks
import com.main.favorites.R

interface FavoritesNavigation {

    fun navigateToGenerationFragment(navController: NavController)

    class Base : FavoritesNavigation {

        override fun navigateToGenerationFragment(navController: NavController) {
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.favoritesNavGraph, true).build()
            navController.navigate(DeepLinks.GENERATION_DEEP_LINK, navOptions)
        }
    }
}