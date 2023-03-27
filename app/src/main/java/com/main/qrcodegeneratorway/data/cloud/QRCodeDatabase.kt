package com.main.qrcodegeneratorway.data.cloud

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.main.core.database.entities.QRCodeData

@Database(entities = [QRCodeData::class], version = 1)
abstract class QRCodeDatabase : RoomDatabase() {

    abstract fun qrCodeDao()

    companion object {
        private var database: QRCodeDatabase? = null

        @Synchronized
        fun getInstance(context: Context) : QRCodeDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(context, QRCodeDatabase::class.java, "qrcode_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                database as QRCodeDatabase
            } else {
                database as QRCodeDatabase
            }
        }
    }
}