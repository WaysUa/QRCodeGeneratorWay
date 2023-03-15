package com.main.generation_from_phone.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.main.core.base.BaseFragment
import com.main.generation_from_phone.R
import com.main.generation_from_phone.databinding.FragmentGenerationFromPhoneBinding

class GenerationFromPhoneFragment : BaseFragment() {
    private val binding by lazy { FragmentGenerationFromPhoneBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}