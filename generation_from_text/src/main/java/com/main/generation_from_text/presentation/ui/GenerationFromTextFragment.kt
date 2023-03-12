package com.main.generation_from_text.presentation.ui

import android.app.Dialog
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
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
            ivQRCode.setImageBitmap(createQRCodeFromText(binding.etText.text.toString()))
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

    private fun createQRCodeFromText(text: String, height: Int = 500, width: Int = 500): Bitmap {
        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height)
        val qrCodeBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val pixels = IntArray(width * height)
        for (y in 0 until height) {
            val offset = y * width
            for (x in 0 until width) {
                pixels[offset + x] = if (bitMatrix.get(x, y)) Color.BLACK else Color.WHITE
            }
        }
        qrCodeBitmap.setPixels(pixels, 0, width, 0, 0, width, height)
        return qrCodeBitmap
    }
}