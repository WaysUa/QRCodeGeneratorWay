package com.main.generation_from_link.domain.usecase

import android.graphics.Bitmap
import com.main.core.base.BaseUseCase
import com.main.generation_from_link.domain.generation.GenerationFromLinkRepository

class GenerationFromLinkUseCase(
    private val generationFromLinkRepository: GenerationFromLinkRepository
) : BaseUseCase() {

    fun execute(text: String, height: Int, width: Int): Bitmap {
        return generationFromLinkRepository.generateQRCodeFromLink(text, height, width)
    }
}