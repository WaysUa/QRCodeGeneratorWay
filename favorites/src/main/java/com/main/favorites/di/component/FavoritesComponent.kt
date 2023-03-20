package com.main.favorites.di.component

import com.main.favorites.di.modules.FavoritesDomainModule
import com.main.favorites.di.modules.FavoritesPresentationModule
import com.main.favorites.presentation.ui.FavoritesFragment
import dagger.Component

@Component(modules = [
    FavoritesDomainModule::class,
    FavoritesPresentationModule::class
])
interface FavoritesComponent {
    fun inject(favoritesFragment: FavoritesFragment)
}