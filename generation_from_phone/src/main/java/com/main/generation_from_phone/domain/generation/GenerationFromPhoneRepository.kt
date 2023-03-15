package com.main.generation_from_phone.domain.generation

import android.graphics.Bitmap
import android.graphics.Color
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter

interface GenerationFromPhoneRepository {

    fun generateQRCodeFromPhone(text: String, height: Int, width: Int): Bitmap

    class Base : GenerationFromPhoneRepository {

        override fun generateQRCodeFromPhone(text: String, height: Int, width: Int): Bitmap {
            val writer = QRCodeWriter()
            val bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height)
            val qrCodeBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val pixels = IntArray(width * height)
            for (y in 0 until height) {
                val offset = y * width
                for (x in 0 until width) {
                    pixels[offset + x] = if (bitMatrix.get(x, y)) Color.BLACK else Color.WHITE
                }
            }
            qrCodeBitmap.setPixels(pixels, 0, width, 0, 0, width, height)
            return qrCodeBitmap
        }
    }
}