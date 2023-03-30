package com.main.favorites.presentation.viewmodel

import android.util.Log
import androidx.navigation.NavController
import com.main.core.base.BaseViewModel
import com.main.core.database.repository.QRCodeCacheRepository
import com.main.favorites.domain.navigation.FavoritesNavigation
import github.com.st235.lib_expandablebottombar.MenuItem

class FavoritesViewModel(
    private val favoritesNavigation: FavoritesNavigation,
    private val qrCodeCacheRepository: QRCodeCacheRepository
): BaseViewModel(), FavoritesNavigation {

    fun getAllQRCodes() {
        val list = qrCodeCacheRepository.getAllQRCodes()
        Log.d("MyLog", "List: $list")
    }

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