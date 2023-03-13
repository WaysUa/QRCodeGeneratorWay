package com.main.generation_from_link.di.modules

import com.main.generation_from_link.data.dialog.ManageGeneratedDialogFromLinkImpl
import com.main.generation_from_link.domain.dialog.ManageGeneratedDialogFromLink
import dagger.Module
import dagger.Provides

@Module
class GenerationFromLinkDataModule {

    @Provides
    fun provideManageGeneratedDialogFromLink(): ManageGeneratedDialogFromLink {
        return ManageGeneratedDialogFromLinkImpl()
    }
}