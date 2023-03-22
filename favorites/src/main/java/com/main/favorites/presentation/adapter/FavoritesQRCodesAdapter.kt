package com.main.favorites.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.main.favorites.R
import com.main.favorites.data.entities.QRCodeData
import com.main.favorites.databinding.ItemFavoriteQrCodeBinding

class FavoritesQRCodesAdapter : RecyclerView.Adapter<FavoritesQRCodesAdapter.FavoritesQRCodesViewHolder>() {
    private val favoritesQRCodes = mutableListOf<QRCodeData>(
        QRCodeData("Hello", "World"),
        QRCodeData("Hello", "World"),
        QRCodeData("Hello", "World"),
        QRCodeData("Hello", "World"),
        QRCodeData("Hello", "World"),
        QRCodeData("Hello", "World"),
        QRCodeData("Hello", "World"),
        QRCodeData("Hello", "World")
    )

    class FavoritesQRCodesViewHolder(view: View): ViewHolder(view) {
        private val binding by lazy { ItemFavoriteQrCodeBinding.bind(view) }

        fun bind(qrCodeData: QRCodeData) {
            binding.tvText.text = qrCodeData.text
            binding.tvGeneratedFrom.text = qrCodeData.generatedFrom
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesQRCodesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite_qr_code, parent, false)
        return FavoritesQRCodesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesQRCodesViewHolder, position: Int) {
        holder.bind(favoritesQRCodes[position])
    }

    override fun getItemCount() = favoritesQRCodes.size
}