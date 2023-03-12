package com.main.generation_from_text.presentation.viewmodel

import android.graphics.Bitmap
import com.main.core.base.BaseViewModel
import com.main.generation_from_text.domain.generation.GenerationFromText

class GenerationFromTextViewModel(
    private val generationFromText: GenerationFromText
) : BaseViewModel(), GenerationFromText {

    override fun generateQRCodeFromText(text: String, height: Int, width: Int): Bitmap {
        return generationFromText.generateQRCodeFromText(text, height, width)
    }

}