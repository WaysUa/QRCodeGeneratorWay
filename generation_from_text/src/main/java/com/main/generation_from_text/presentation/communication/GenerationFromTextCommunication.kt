package com.main.generation_from_text.presentation.communication

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.core.communication.Communication

interface GenerationFromTextCommunication : ObserveGenerationFromTextCommunication {

    fun mapImage(bitmap: Bitmap)

    class Base(
        private val generationFormTextImageCommunication: GenerationFormTextImageCommunication
    ) : GenerationFromTextCommunication {

        override fun mapImage(bitmap: Bitmap) {
            generationFormTextImageCommunication.map(bitmap)
        }

        override fun observeImage(owner: LifecycleOwner, observer: Observer<Bitmap>) {
            generationFormTextImageCommunication.observe(owner, observer)
        }
    }
}

interface ObserveGenerationFromTextCommunication {
    fun observeImage(owner: LifecycleOwner, observer: Observer<Bitmap>)
}

interface GenerationFormTextImageCommunication: Communication.Mutable<Bitmap> {
    class Base: Communication.Ui<Bitmap>(), GenerationFormTextImageCommunication
}