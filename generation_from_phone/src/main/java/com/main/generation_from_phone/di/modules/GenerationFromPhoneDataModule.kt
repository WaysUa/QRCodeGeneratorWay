package com.main.generation_from_phone.di.modules

import com.main.generation_from_phone.data.dialog.ManageGeneratedDialogFromPhoneImpl
import com.main.generation_from_phone.domain.dialog.ManageGeneratedDialogFromPhone
import dagger.Module
import dagger.Provides

@Module
class GenerationFromPhoneDataModule {

    @Provides
    fun provideManageGeneratedDialogFromPhone(): ManageGeneratedDialogFromPhone {
        return ManageGeneratedDialogFromPhoneImpl()
    }
}