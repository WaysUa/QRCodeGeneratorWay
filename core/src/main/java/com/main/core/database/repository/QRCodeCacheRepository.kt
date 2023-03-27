package com.main.core.database.repository

import com.main.core.database.entities.QRCodeData

interface QRCodeCacheRepository {

    fun addQRCode(qrCodeData: QRCodeData)

    fun deleteQRCode(qrCodeData: QRCodeData)

    fun deleteAllQRCodes(qrCodes: List<QRCodeData>)

    fun getAllQRCodes(): List<QRCodeData>
}