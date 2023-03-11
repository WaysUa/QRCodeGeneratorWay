package com.main.generate.di.modules

import com.main.generate.domain.navigation.GenerationNavigation
import dagger.Module
import dagger.Provides

@Module
class GenerationDomainModule {

    @Provides
    fun provideGenerationNavigation(): GenerationNavigation {
        return GenerationNavigation.Base()
    }

}