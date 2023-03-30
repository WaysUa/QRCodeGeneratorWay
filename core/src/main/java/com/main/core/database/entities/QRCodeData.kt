package com.main.core.database.entities

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "qr_codes_table")
data class QRCodeData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String,
    val generatedFrom: String,
    val image: Bitmap
)