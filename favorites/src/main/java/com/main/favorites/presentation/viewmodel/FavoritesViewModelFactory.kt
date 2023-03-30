package com.main.favorites.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.main.core.base.BaseViewModelFactory
import com.main.core.database.repository.QRCodeCacheRepository
import com.main.favorites.domain.navigation.FavoritesNavigation

class FavoritesViewModelFactory(
    private val favoritesNavigation: FavoritesNavigation,
    private val qrCodeCacheRepository: QRCodeCacheRepository
) : BaseViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FavoritesViewModel(
            favoritesNavigation = favoritesNavigation,
            qrCodeCacheRepository = qrCodeCacheRepository
        ) as T
    }
}