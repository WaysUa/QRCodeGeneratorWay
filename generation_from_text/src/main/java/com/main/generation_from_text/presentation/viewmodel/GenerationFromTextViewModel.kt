package com.main.generation_from_text.presentation.viewmodel

import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.core.base.BaseViewModel
import com.main.core.database.entities.QRCodeData
import com.main.core.database.repository.QRCodeCacheRepository
import com.main.generation_from_text.domain.dialog.ManageGeneratedDialogFromText
import com.main.generation_from_text.domain.usecase.GenerationFromTextUseCase
import com.main.generation_from_text.presentation.communication.GenerationFromTextCommunication
import com.main.generation_from_text.presentation.communication.ObserveGenerationFromTextCommunication

class GenerationFromTextViewModel(
    private val generationFromTextUseCase: GenerationFromTextUseCase,
    private val generationFromTextCommunication: GenerationFromTextCommunication,
    private val manageGeneratedDialogFromText: ManageGeneratedDialogFromText,
    private val qrCodeCacheRepository: QRCodeCacheRepository
) : BaseViewModel(), ObserveGenerationFromTextCommunication, ManageGeneratedDialogFromText {

    fun generateQRCodeFromText(text: String, height: Int = 500, width: Int = 500) {
        val image = generationFromTextUseCase.execute(text, height, width)
        generationFromTextCommunication.mapImage(image)
    }

    fun addQrCodeToDatabase(qrCodeData: QRCodeData) {
        qrCodeCacheRepository.addQRCode(qrCodeData)
    }

    override fun observeImage(owner: LifecycleOwner, observer: Observer<Bitmap>) {
        generationFromTextCommunication.observeImage(owner, observer)
    }

    override fun createDialog(context: Context): Dialog {
        return manageGeneratedDialogFromText.createDialog(context)
    }
}