package com.main.generation_from_text.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.main.core.base.BaseFragment
import com.main.generation_from_text.R
import com.main.generation_from_text.databinding.FragmentGenerationFromTextBinding

class GenerationFromTextFragment : BaseFragment() {
    private val binding by lazy { FragmentGenerationFromTextBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}