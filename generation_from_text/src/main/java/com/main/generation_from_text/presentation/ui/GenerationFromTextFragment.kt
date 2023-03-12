package com.main.generation_from_text.presentation.ui

import android.app.Dialog
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as ProvideGenerationFromTextComponent).provideGenerationFromTextComponent().inject(this)

        binding.btnGenerate.setOnClickListener {
            val dialog = Dialog(requireContext())
            dialog.setContentView(com.main.core.R.layout.dialog_qr_code)

            val layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(dialog.window?.attributes)
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT

            val tvTextInfo = dialog.findViewById<TextView>(com.main.core.R.id.tvTextInfo)
            val btnFavorite = dialog.findViewById<FloatingActionButton>(com.main.core.R.id.btnFavorite)
            val btnMoreOptions = dialog.findViewById<FloatingActionButton>(com.main.core.R.id.btnMoreOptions)
            val ivQRCode = dialog.findViewById<ImageView>(com.main.core.R.id.ivQRCode)
            val btnClose = dialog.findViewById<ImageView>(com.main.core.R.id.btnClose)

            tvTextInfo.text = binding.etText.text.toString()
            val image = generationFromTextViewModel.generateQRCodeFromText(binding.etText.text.toString())
            ivQRCode.setImageBitmap(image)
            btnClose.setOnClickListener { dialog.hide() }

            dialog.window?.attributes = layoutParams
            dialog.show()
        }

        binding.etText.doOnTextChanged { text, start, before, count ->
            if (text?.isNotEmpty() == true) {
                binding.btnGenerate.visibility = View.VISIBLE
            } else {
                binding.btnGenerate.visibility = View.GONE
            }
        }
    }
}