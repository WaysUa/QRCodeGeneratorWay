package com.main.generation_from_text.di.modules

import com.main.generation_from_text.data.dialog.ManageGeneratedDialogFromTextImpl
import com.main.generation_from_text.domain.dialog.ManageGeneratedDialogFromText
import dagger.Module
import dagger.Provides

@Module
class GenerationFromTextDataModule {

    @Provides
    fun provideManageGeneratedDialogFromText(): ManageGeneratedDialogFromText {
        return ManageGeneratedDialogFromTextImpl()
    }
}