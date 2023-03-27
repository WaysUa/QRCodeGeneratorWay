package com.main.core.database.dao

import androidx.room.*
import com.main.core.database.entities.QRCodeData

@Entity
@Dao
interface QRCodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQRCode(qrCodeData: QRCodeData)

    @Delete
    fun deleteQRCode(qrCodeData: QRCodeData)

    @Delete
    fun deleteAllQRCodes(qrCodes: List<QRCodeData>)

    @Query("SELECT * FROM qr_codes_table")
    fun getAllQRCodes(): List<QRCodeData>
}