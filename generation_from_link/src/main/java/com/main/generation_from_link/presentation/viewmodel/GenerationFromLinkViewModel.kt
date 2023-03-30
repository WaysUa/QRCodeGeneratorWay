package com.main.generation_from_link.presentation.viewmodel

import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.core.base.BaseViewModel
import com.main.core.database.entities.QRCodeData
import com.main.core.database.repository.QRCodeCacheRepository
import com.main.generation_from_link.domain.dialog.ManageGeneratedDialogFromLink
import com.main.generation_from_link.domain.usecase.GenerationFromLinkUseCase
import com.main.generation_from_link.presentation.communication.GenerationFromLinkCommunication
import com.main.generation_from_link.presentation.communication.ObserveGenerationFromLinkCommunication

class GenerationFromLinkViewModel(
    private val generationFromLinkUseCase: GenerationFromLinkUseCase,
    private val generationFromLinkCommunication: GenerationFromLinkCommunication,
    private val manageGeneratedDialogFromLink: ManageGeneratedDialogFromLink,
    val qrCodeCacheRepository: QRCodeCacheRepository
) : BaseViewModel(), ObserveGenerationFromLinkCommunication, ManageGeneratedDialogFromLink {

    fun addQrCodeToDatabase(qrCodeData: QRCodeData) {
        qrCodeCacheRepository.addQRCode(qrCodeData)
    }

    fun generateQRCodeFromLink(text: String, height: Int = 500, width: Int = 500) {
        val image = generationFromLinkUseCase.execute(text, height, width)
        generationFromLinkCommunication.mapImage(image)
    }

    override fun observeImage(owner: LifecycleOwner, observer: Observer<Bitmap>) {
        generationFromLinkCommunication.observeImage(owner, observer)
    }

    override fun createDialog(context: Context): Dialog {
        return manageGeneratedDialogFromLink.createDialog(context)
    }
}