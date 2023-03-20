package com.main.generate.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.main.core.base.BaseFragment
import com.main.generate.databinding.FragmentGenerationBinding
import com.main.generate.di.provider.ProvideGenerationComponent
import com.main.generate.presentation.viewmodel.GenerationViewModel
import com.main.generate.presentation.viewmodel.GenerationViewModelFactory
import javax.inject.Inject

class GenerationFragment : BaseFragment() {
    private val binding by lazy { FragmentGenerationBinding.inflate(layoutInflater) }
    @Inject
    lateinit var generationViewModelFactory: GenerationViewModelFactory
    private val generationViewModel: GenerationViewModel by activityViewModels { generationViewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as ProvideGenerationComponent).provideGenerationComponent().inject(this)

        binding.bottomNavigationBar.menu.select(com.main.core.R.id.itemGeneration)
        binding.bottomNavigationBar.onItemSelectedListener = { _, menuItem, _ ->
            generationViewModel.manageMenuItem(menuItem, findNavController())
        }

        binding.btnText.setOnClickListener {
            generationViewModel.navigateToGenerationFromTextFragment(findNavController())
        }

        binding.btnLink.setOnClickListener {
            generationViewModel.navigateToGenerationFromLinkFragment(findNavController())
        }

        binding.btnPhone.setOnClickListener {
            generationViewModel.navigateToGenerationFromPhoneFragment(findNavController())
        }
    }
}