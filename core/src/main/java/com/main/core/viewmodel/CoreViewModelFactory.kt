package com.main.core.viewmodel

import androidx.lifecycle.ViewModel
import com.main.core.base.BaseViewModelFactory
import com.main.core.database.repository.QRCodeCacheRepository

class CoreViewModelFactory(
    private val qrCodeCacheRepository: QRCodeCacheRepository
) : BaseViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CoreViewModel(
            qrCodeCacheRepository = qrCodeCacheRepository
        ) as T
    }
}