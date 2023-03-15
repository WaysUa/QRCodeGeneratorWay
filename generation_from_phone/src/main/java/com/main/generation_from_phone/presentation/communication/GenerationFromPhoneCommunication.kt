package com.main.generation_from_phone.presentation.communication

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.core.communication.Communication

interface GenerationFromPhoneCommunication : ObserveGenerationFromPhoneCommunication {

    fun mapImage(bitmap: Bitmap)

    class Base(
        private val generationFromPhoneImageCommunication: GenerationFromPhoneImageCommunication
    ) : GenerationFromPhoneCommunication {

        override fun mapImage(bitmap: Bitmap) {
            generationFromPhoneImageCommunication.map(bitmap)
        }

        override fun observeImage(owner: LifecycleOwner, observer: Observer<Bitmap>) {
            generationFromPhoneImageCommunication.observe(owner, observer)
        }
    }
}

interface ObserveGenerationFromPhoneCommunication {
    fun observeImage(owner: LifecycleOwner, observer: Observer<Bitmap>)
}

interface GenerationFromPhoneImageCommunication: Communication.Mutable<Bitmap> {
    class Base: Communication.SingleUi<Bitmap>(), GenerationFromPhoneImageCommunication
}