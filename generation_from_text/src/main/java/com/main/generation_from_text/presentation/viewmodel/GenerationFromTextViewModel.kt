package com.main.generation_from_text.presentation.viewmodel

import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import android.view.WindowManager
import com.main.core.base.BaseViewModel
import com.main.generation_from_text.domain.generation.GenerationFromTextRepository

class GenerationFromTextViewModel(
    private val generationFromTextRepository: GenerationFromTextRepository
) : BaseViewModel(), GenerationFromTextRepository {

    fun createDialog(context: Context): Dialog {
        val dialog = Dialog(context)
        dialog.setContentView(com.main.core.R.layout.dialog_qr_code_from_text)

        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(dialog.window?.attributes)
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT

        dialog.window?.attributes = layoutParams
        return dialog
    }

    override fun generateQRCodeFromText(text: String, height: Int, width: Int): Bitmap {
        return generationFromTextRepository.generateQRCodeFromText(text, height, width)
    }
}