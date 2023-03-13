package com.main.generation_from_text.domain.usecase

import android.graphics.Bitmap
import com.main.core.base.BaseUseCase
import com.main.generation_from_text.domain.generation.GenerationFromTextRepository

class GenerationFromTextUseCase(
    private val generationFromTextRepository: GenerationFromTextRepository
) : BaseUseCase() {

    fun execute(text: String, height: Int, width: Int): Bitmap {
        return generationFromTextRepository.generateQRCodeFromText(text, height, width)
    }
}