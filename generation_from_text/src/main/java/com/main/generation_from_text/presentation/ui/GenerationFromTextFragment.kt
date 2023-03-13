package com.main.generation_from_text.presentation.ui

import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.main.core.SimpleTextWatcher
import com.main.core.base.BaseFragment
import com.main.generation_from_text.databinding.FragmentGenerationFromTextBinding
import com.main.generation_from_text.di.provider.ProvideGenerationFromTextComponent
import com.main.generation_from_text.presentation.viewmodel.GenerationFromTextViewModel
import com.main.generation_from_text.presentation.viewmodel.GenerationFromTextViewModelFactory
import javax.inject.Inject

class GenerationFromTextFragment : BaseFragment() {
    private val binding by lazy { FragmentGenerationFromTextBinding.inflate(layoutInflater) }
    @Inject
    lateinit var generationFromTextViewModelFactory: GenerationFromTextViewModelFactory
    private val generationFromTextViewModel: GenerationFromTextViewModel by activityViewModels { generationFromTextViewModelFactory }

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
        (requireActivity().applicationContext as ProvideGenerationFromTextComponent).provideGenerationFromTextComponent().inject(this)

        binding.btnGenerate.setOnClickListener {
            val dialog = generationFromTextViewModel.createDialog(requireContext())
            val tvTextInfo = dialog.findViewById<TextView>(com.main.core.R.id.tvTextInfo)
            val btnFavorite = dialog.findViewById<FloatingActionButton>(com.main.core.R.id.btnFavorite)
            val btnMoreOptions = dialog.findViewById<FloatingActionButton>(com.main.core.R.id.btnMoreOptions)
            val ivQRCode = dialog.findViewById<ImageView>(com.main.core.R.id.ivQRCode)
            val btnClose = dialog.findViewById<ImageView>(com.main.core.R.id.btnClose)

            tvTextInfo.text = binding.etText.text
            val image = generationFromTextViewModel.generateQRCodeFromText(binding.etText.text.toString())
            ivQRCode.setImageBitmap(image)

            btnClose.setOnClickListener { dialog.hide() }
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