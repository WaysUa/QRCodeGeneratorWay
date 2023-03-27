package com.main.core.database.repository

import com.main.core.database.dao.QRCodeDao
import com.main.core.database.entities.QRCodeData

class QRCodeCacheRepositoryImpl(private val qrCodeDao: QRCodeDao): QRCodeCacheRepository {

    override fun addQRCode(qrCodeData: QRCodeData) {
        qrCodeDao.addQRCode(qrCodeData)
    }

    override fun deleteQRCode(qrCodeData: QRCodeData) {
        qrCodeDao.deleteQRCode(qrCodeData)
    }

    override fun deleteAllQRCodes(qrCodes: List<QRCodeData>) {
        return qrCodeDao.deleteAllQRCodes(qrCodes)
    }

    override fun getAllQRCodes(): List<QRCodeData> {
        return qrCodeDao.getAllQRCodes()
    }
}