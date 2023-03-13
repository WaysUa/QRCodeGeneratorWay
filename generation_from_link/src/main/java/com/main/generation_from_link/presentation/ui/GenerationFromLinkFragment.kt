package com.main.generation_from_link.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.main.core.SimpleTextWatcher
import com.main.core.base.BaseFragment
import com.main.generation_from_link.R
import com.main.generation_from_link.databinding.FragmentGenerationFromLinkBinding
import com.main.generation_from_link.di.provider.ProvideGenerationFromLinkComponent
import com.main.generation_from_link.presentation.viewmodel.GenerationFromLinkViewModel
import com.main.generation_from_link.presentation.viewmodel.GenerationFromLinkViewModelFactory
import javax.inject.Inject

class GenerationFromLinkFragment : BaseFragment() {
    private val binding by lazy { FragmentGenerationFromLinkBinding.inflate(layoutInflater) }
    @Inject
    lateinit var generationFromLinkViewModelFactory: GenerationFromLinkViewModelFactory
    private val generationFromLinkViewModel: GenerationFromLinkViewModel by activityViewModels { generationFromLinkViewModelFactory }

    private val mainTextWatcher = object : SimpleTextWatcher() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (s?.isNotEmpty() == true) {
                binding.btnGenerate.visibility = View.VISIBLE
            } else {
                binding.btnGenerate.visibility = View.GONE
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as ProvideGenerationFromLinkComponent).provideGenerationFromLinkComponent().inject(this)

        binding.btnGenerate.setOnClickListener {
            generationFromLinkViewModel.generateQRCodeFromLink(binding.etText.text.toString())
        }

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        generationFromLinkViewModel.observeImage(this) { image ->
            val dialog = generationFromLinkViewModel.createDialog(requireContext())

            val tvTextInfo = dialog.findViewById<TextView>(R.id.tvTextInfo)
            val btnFavorite = dialog.findViewById<FloatingActionButton>(R.id.btnFavorite)
            val btnMoreOptions = dialog.findViewById<FloatingActionButton>(R.id.btnMoreOptions)
            val ivQRCode = dialog.findViewById<ImageView>(R.id.ivQRCode)
            val btnClose = dialog.findViewById<ImageView>(R.id.btnClose)

            tvTextInfo.text = binding.etText.text
            btnClose.setOnClickListener { dialog.hide() }
            ivQRCode.setImageBitmap(image)
            dialog.show()
        }
    }

    override fun onResume() {
        binding.etText.addTextChangedListener(mainTextWatcher)
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.etText.removeTextChangedListener(mainTextWatcher)
    }
}