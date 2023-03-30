package com.main.core.di.modules

import com.main.core.database.dao.QRCodeDao
import com.main.core.database.repository.QRCodeCacheRepository
import com.main.core.database.repository.QRCodeCacheRepositoryImpl
import com.main.core.viewmodel.CoreViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CoreModule(private val qrCodeDao: QRCodeDao) {

    @Provides
    fun provideMainViewModelFactory(qrCodeCacheRepository: QRCodeCacheRepository): CoreViewModelFactory {
        return CoreViewModelFactory(qrCodeCacheRepository)
    }

    @Provides
    fun provideQRCodeCacheRepository(): QRCodeCacheRepository {
        return QRCodeCacheRepositoryImpl(qrCodeDao = qrCodeDao)
    }

}