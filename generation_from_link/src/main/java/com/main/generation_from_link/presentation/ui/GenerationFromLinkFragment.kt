package com.main.generation_from_link.presentation.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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
    private lateinit var clipboardManager:  ClipboardManager
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
        clipboardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        binding.btnGenerate.setOnClickListener {
            generationFromLinkViewModel.generateQRCodeFromLink(binding.etText.text.toString())
        }

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        generationFromLinkViewModel.observeImage(this) { image ->
            val dialog = generationFromLinkViewModel.createDialog(requireContext())

            val tvLink = dialog.findViewById<TextView>(R.id.tvLink)
            val btnFavorite = dialog.findViewById<FloatingActionButton>(R.id.btnFavorite)
            val btnMoreOptions = dialog.findViewById<FloatingActionButton>(R.id.btnMoreOptions)
            val ivQRCode = dialog.findViewById<ImageView>(R.id.ivQRCode)
            val btnClose = dialog.findViewById<ImageView>(R.id.btnClose)

            tvLink.text = formTextFromLayout()
            tvLink.setOnClickListener {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tvLink.text.toString()))
                    startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(requireContext(), R.string.link_is_wrong, Toast.LENGTH_SHORT).show()
                }
            }
            tvLink.setOnLongClickListener {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("Text", tvLink.text))
                true
            }
            btnClose.setOnClickListener { dialog.hide() }
            ivQRCode.setImageBitmap(image)
            dialog.show()
        }
    }

    private fun formTextFromLayout(): Spanned {
        val htmlTaggedString = "<u>${binding.etText.text}</u>"
        return Html.fromHtml(htmlTaggedString, 0)
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