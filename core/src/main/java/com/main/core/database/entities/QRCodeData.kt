package com.main.core.database.entities

import android.graphics.Bitmap
import androidx.room.Entity

@Entity(tableName = "qr_codes_table")
data class QRCodeData(
    val text: String,
    val generatedFrom: String,
    val image: Bitmap
)