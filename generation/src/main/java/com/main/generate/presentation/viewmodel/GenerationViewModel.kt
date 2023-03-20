package com.main.generate.presentation.viewmodel

import androidx.navigation.NavController
import com.main.core.base.BaseViewModel
import com.main.generate.domain.navigation.GenerationNavigation
import github.com.st235.lib_expandablebottombar.MenuItem

class GenerationViewModel(
    private val generationNavigation: GenerationNavigation
) : BaseViewModel(), GenerationNavigation {

    fun manageMenuItem(menuItem: MenuItem, navController: NavController): Boolean {
        when (menuItem.id) {
            com.main.core.R.id.itemFavorites -> generationNavigation.navigateToFavoritesFragment(navController)
        }
        return true
    }

    override fun navigateToGenerationFromTextFragment(navController: NavController) {
        generationNavigation.navigateToGenerationFromTextFragment(navController)
    }

    override fun navigateToGenerationFromLinkFragment(navController: NavController) {
        generationNavigation.navigateToGenerationFromLinkFragment(navController)
    }

    override fun navigateToGenerationFromPhoneFragment(navController: NavController) {
        generationNavigation.navigateToGenerationFromPhoneFragment(navController)
    }

    override fun navigateToFavoritesFragment(navController: NavController) {
        generationNavigation.navigateToFavoritesFragment(navController)
    }
}