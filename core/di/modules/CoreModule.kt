package com.main.core.di.modules

import com.main.core.communication.CoreCommunication
import com.main.core.viewmodel.CoreViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CoreModule {

    @Provides
    fun provideMainViewModelFactory(
        coreCommunication: CoreCommunication
    ): CoreViewModelFactory {
        return CoreViewModelFactory(coreCommunication)
    }

    @Provides
    fun provideMainCommunication(

    ): CoreCommunication {
        return CoreCommunication.Base(

        )
    }
}