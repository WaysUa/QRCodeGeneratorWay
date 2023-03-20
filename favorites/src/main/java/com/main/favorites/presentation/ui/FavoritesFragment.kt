package com.main.favorites.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.main.core.base.BaseFragment
import com.main.favorites.R
import com.main.favorites.databinding.FragmentFavoritesBinding
import com.main.favorites.di.provider.ProvideFavoritesComponent
import com.main.favorites.presentation.viewmodel.FavoritesViewModel
import com.main.favorites.presentation.viewmodel.FavoritesViewModelFactory
import javax.inject.Inject

class FavoritesFragment : BaseFragment() {
    private val binding by lazy { FragmentFavoritesBinding.inflate(layoutInflater) }
    @Inject
    lateinit var favoritesViewModelFactory: FavoritesViewModelFactory
    private val favoritesViewModel: FavoritesViewModel by activityViewModels { favoritesViewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as ProvideFavoritesComponent).provideFavoritesComponent().inject(this)

        binding.bottomNavigationBar.menu.select(com.main.core.R.id.itemFavorites)
        binding.bottomNavigationBar.onItemSelectedListener = { _, menuItem, _ ->
            favoritesViewModel.manageMenuItem(menuItem, findNavController())
        }
    }
}