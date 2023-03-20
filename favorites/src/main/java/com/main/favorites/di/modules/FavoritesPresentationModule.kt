package com.main.favorites.di.modules

import com.main.favorites.domain.navigation.FavoritesNavigation
import com.main.favorites.presentation.viewmodel.FavoritesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class FavoritesPresentationModule {

    @Provides
    fun provideFavoritesViewModelFactory(favoritesNavigation: FavoritesNavigation): FavoritesViewModelFactory {
        return FavoritesViewModelFactory(favoritesNavigation)
    }

}