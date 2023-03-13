package com.main.generation_from_link.presentation.communication

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.core.communication.Communication

interface GenerationFromLinkCommunication : ObserveGenerationFromLinkCommunication {

    fun mapImage(bitmap: Bitmap)

    class Base(
        private val generationFromLinkImageCommunication: GenerationFromLinkImageCommunication
    ) : GenerationFromLinkCommunication {

        override fun mapImage(bitmap: Bitmap) {
            generationFromLinkImageCommunication.map(bitmap)
        }

        override fun observeImage(owner: LifecycleOwner, observer: Observer<Bitmap>) {
            generationFromLinkImageCommunication.observe(owner, observer)
        }
    }
}

interface ObserveGenerationFromLinkCommunication {
    fun observeImage(owner: LifecycleOwner, observer: Observer<Bitmap>)
}

interface GenerationFromLinkImageCommunication: Communication.Mutable<Bitmap> {
    class Base: Communication.SingleUi<Bitmap>(), GenerationFromLinkImageCommunication
}