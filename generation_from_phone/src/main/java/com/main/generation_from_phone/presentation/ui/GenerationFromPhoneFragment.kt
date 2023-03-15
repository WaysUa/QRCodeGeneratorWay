package com.main.generation_from_phone.presentation.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
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
import com.main.generation_from_phone.R
import com.main.generation_from_phone.databinding.FragmentGenerationFromPhoneBinding
import com.main.generation_from_phone.di.provider.ProvideGenerationFromPhoneComponent
import com.main.generation_from_phone.presentation.viewmodel.GenerationFromPhoneViewModel
import com.main.generation_from_phone.presentation.viewmodel.GenerationFromPhoneViewModelFactory
import javax.inject.Inject

class GenerationFromPhoneFragment : BaseFragment() {
    private val binding by lazy { FragmentGenerationFromPhoneBinding.inflate(layoutInflater) }
    @Inject
    lateinit var generationFromTextViewModelFactory: GenerationFromPhoneViewModelFactory
    private val generationFromTextViewModel: GenerationFromPhoneViewModel by activityViewModels { generationFromTextViewModelFactory }
    private lateinit var clipboardManager: ClipboardManager
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
        (requireActivity().applicationContext as ProvideGenerationFromPhoneComponent).provideGenerationFromPhoneComponent().inject(this)
        clipboardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        binding.btnGenerate.setOnClickListener {
            generationFromTextViewModel.generateQRCodeFromPhone(binding.etPhoneNumber.text.toString())
        }

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        generationFromTextViewModel.observeImage(this) { image ->
            val dialog = generationFromTextViewModel.createDialog(requireContext())

            val tvTextInfo = dialog.findViewById<TextView>(R.id.tvPhoneNumber)
            val btnFavorite = dialog.findViewById<FloatingActionButton>(R.id.btnFavorite)
            val btnMoreOptions = dialog.findViewById<FloatingActionButton>(R.id.btnMoreOptions)
            val ivQRCode = dialog.findViewById<ImageView>(R.id.ivQRCode)
            val btnClose = dialog.findViewById<ImageView>(R.id.btnClose)

            tvTextInfo.text = binding.etPhoneNumber.text
            tvTextInfo.setOnLongClickListener {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("Text", tvTextInfo.text))
                true
            }
            btnClose.setOnClickListener { dialog.hide() }
            ivQRCode.setImageBitmap(image)
            dialog.show()
        }
    }

    override fun onResume() {
        binding.etPhoneNumber.addTextChangedListener(mainTextWatcher)
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.etPhoneNumber.removeTextChangedListener(mainTextWatcher)
    }
}