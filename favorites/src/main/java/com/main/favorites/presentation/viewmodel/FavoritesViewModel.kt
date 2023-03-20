package com.main.favorites.presentation.viewmodel

import androidx.navigation.NavController
import com.main.core.base.BaseViewModel
import com.main.favorites.domain.navigation.FavoritesNavigation
import github.com.st235.lib_expandablebottombar.MenuItem

class FavoritesViewModel(
    private val favoritesNavigation: FavoritesNavigation
): BaseViewModel(), FavoritesNavigation {

    fun manageMenuItem(menuItem: MenuItem, navController: NavController): Boolean {
        when (menuItem.id) {
            com.main.core.R.id.itemGeneration -> favoritesNavigation.navigateToGenerationFragment(navController)
        }
        return true
    }

    override fun navigateToGenerationFragment(navController: NavController) {
        favoritesNavigation.navigateToGenerationFragment(navController)
    }
}