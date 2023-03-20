package com.main.favorites.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.main.core.base.BaseViewModelFactory
import com.main.favorites.domain.navigation.FavoritesNavigation

class FavoritesViewModelFactory(
    private val favoritesNavigation: FavoritesNavigation
) : BaseViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FavoritesViewModel(
            favoritesNavigation = favoritesNavigation
        ) as T
    }
}