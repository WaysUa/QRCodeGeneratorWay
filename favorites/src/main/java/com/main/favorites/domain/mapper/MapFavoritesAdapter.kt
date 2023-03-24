package com.main.favorites.domain.mapper

import com.main.favorites.data.entities.QRCodeData

interface MapFavoritesAdapter {

    fun mapAll(list: List<QRCodeData>)

    fun map(qrCodeData: QRCodeData)
}