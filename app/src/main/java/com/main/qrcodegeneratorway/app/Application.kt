package com.main.qrcodegeneratorway.app

import android.app.Application
import com.main.generate.di.component.DaggerGenerationComponent
import com.main.generate.di.component.GenerationComponent
import com.main.generate.di.modules.GenerationDomainModule
import com.main.generate.di.modules.GenerationPresentationModule
import com.main.generate.di.provider.ProvideGenerationComponent

class Application : Application(), ProvideGenerationComponent {

    private val generationComponent by lazy {
        DaggerGenerationComponent
            .builder()
            .generationDomainModule(GenerationDomainModule())
            .generationPresentationModule(GenerationPresentationModule())
            .build()
    }

    override fun provideGenerationComponent(): GenerationComponent = generationComponent

}