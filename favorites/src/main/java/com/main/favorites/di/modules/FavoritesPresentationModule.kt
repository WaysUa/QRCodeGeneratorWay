package com.main.favorites.di.modules

import com.main.core.database.repository.QRCodeCacheRepository
import com.main.favorites.domain.navigation.FavoritesNavigation
import com.main.favorites.presentation.viewmodel.FavoritesViewModelFactory
import dagger.Module
import dagger.Provides
import kotlin.math.sqrt

@Module
class FavoritesPresentationModule {

    @Provides
    fun provideFavoritesViewModelFactory(
        favoritesNavigation: FavoritesNavigation,
        qrCodeCacheRepository: QRCodeCacheRepository
    ): FavoritesViewModelFactory {
        return FavoritesViewModelFactory(
            favoritesNavigation = favoritesNavigation,
            qrCodeCacheRepository = qrCodeCacheRepository
        )
    }
}