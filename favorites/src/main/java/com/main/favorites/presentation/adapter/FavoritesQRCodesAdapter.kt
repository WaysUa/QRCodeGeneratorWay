package com.main.favorites.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.main.favorites.R
import com.main.favorites.data.entities.QRCodeData
import com.main.favorites.databinding.ItemFavoriteQrCodeBinding
import com.main.favorites.domain.mapper.MapFavoritesAdapter

class FavoritesQRCodesAdapter :
    RecyclerView.Adapter<FavoritesQRCodesAdapter.FavoritesQRCodesViewHolder>(), MapFavoritesAdapter
{
    private val favoritesQRCodes = mutableListOf<QRCodeData>()

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

    @SuppressLint("NotifyDataSetChanged")
    override fun mapAll(list: List<QRCodeData>) {
        favoritesQRCodes.addAll(list)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun map(qrCodeData: QRCodeData) {
        favoritesQRCodes.add(qrCodeData)
        notifyDataSetChanged()
    }
}