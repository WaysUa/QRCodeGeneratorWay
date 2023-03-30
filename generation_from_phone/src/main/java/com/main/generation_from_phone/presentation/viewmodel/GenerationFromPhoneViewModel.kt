package com.main.generation_from_phone.presentation.viewmodel

import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.core.base.BaseViewModel
import com.main.core.database.entities.QRCodeData
import com.main.core.database.repository.QRCodeCacheRepository
import com.main.generation_from_phone.domain.dialog.ManageGeneratedDialogFromPhone
import com.main.generation_from_phone.domain.usecase.GenerationFromPhoneUseCase
import com.main.generation_from_phone.presentation.communication.GenerationFromPhoneCommunication
import com.main.generation_from_phone.presentation.communication.ObserveGenerationFromPhoneCommunication

class GenerationFromPhoneViewModel(
    private val generationFromPhoneUseCase: GenerationFromPhoneUseCase,
    private val generationFromPhoneCommunication: GenerationFromPhoneCommunication,
    private val manageGeneratedDialogFromPhone: ManageGeneratedDialogFromPhone,
    private val qrCodeCacheRepository: QRCodeCacheRepository
) : BaseViewModel(), ObserveGenerationFromPhoneCommunication, ManageGeneratedDialogFromPhone {

    fun generateQRCodeFromPhone(text: String, height: Int = 500, width: Int = 500) {
        val image = generationFromPhoneUseCase.execute(text, height, width)
        generationFromPhoneCommunication.mapImage(image)
    }

    fun addQrCodeToDatabase(qrCodeData: QRCodeData) {
        qrCodeCacheRepository.addQRCode(qrCodeData)
    }

    override fun observeImage(owner: LifecycleOwner, observer: Observer<Bitmap>) {
        generationFromPhoneCommunication.observeImage(owner, observer)
    }

    override fun createDialog(context: Context): Dialog {
        return manageGeneratedDialogFromPhone.createDialog(context)
    }
}