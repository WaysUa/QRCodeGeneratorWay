package com.main.core.viewmodel

import com.main.core.base.BaseViewModel
import com.main.core.database.repository.QRCodeCacheRepository

class CoreViewModel(
    private val qrCodeCacheRepository: QRCodeCacheRepository
) : BaseViewModel() {


}