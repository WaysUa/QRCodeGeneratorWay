package com.main.favorites.di.modules

import com.main.favorites.domain.navigation.FavoritesNavigation
import dagger.Module
import dagger.Provides

@Module
class FavoritesDomainModule {

    @Provides
    fun provideFavoritesNavigation(): FavoritesNavigation {
        return FavoritesNavigation.Base()
    }

}