package com.main.generation_from_phone.domain.usecase

import android.graphics.Bitmap
import com.main.core.base.BaseUseCase
import com.main.generation_from_phone.domain.generation.GenerationFromPhoneRepository

class GenerationFromPhoneUseCase(
    private val generationFromPhoneRepository: GenerationFromPhoneRepository
) : BaseUseCase() {

    fun execute(text: String, height: Int, width: Int): Bitmap {
        return generationFromPhoneRepository.generateQRCodeFromPhone(text, height, width)
    }
}