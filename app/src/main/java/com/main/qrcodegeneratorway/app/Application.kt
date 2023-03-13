package com.main.qrcodegeneratorway.app

import android.app.Application
import com.main.generate.di.component.DaggerGenerationComponent
import com.main.generate.di.component.GenerationComponent
import com.main.generate.di.modules.GenerationDomainModule
import com.main.generate.di.modules.GenerationPresentationModule
import com.main.generate.di.provider.ProvideGenerationComponent
import com.main.generation_from_link.di.component.DaggerGenerationFromLinkComponent
import com.main.generation_from_link.di.component.GenerationFromLinkComponent
import com.main.generation_from_link.di.modules.GenerationFromLinkDataModule
import com.main.generation_from_link.di.modules.GenerationFromLinkDomainModule
import com.main.generation_from_link.di.modules.GenerationFromLinkPresentationModule
import com.main.generation_from_link.di.provider.ProvideGenerationFromLinkComponent
import com.main.generation_from_text.di.component.DaggerGenerationFromTextComponent
import com.main.generation_from_text.di.component.GenerationFromTextComponent
import com.main.generation_from_text.di.modules.GenerationFromTextDataModule
import com.main.generation_from_text.di.modules.GenerationFromTextDomainModule
import com.main.generation_from_text.di.modules.GenerationFromTextPresentationModule
import com.main.generation_from_text.di.provider.ProvideGenerationFromTextComponent

class Application : Application(), ProvideGenerationComponent, ProvideGenerationFromTextComponent,
    ProvideGenerationFromLinkComponent {

    private val generationComponent by lazy {
        DaggerGenerationComponent
            .builder()
            .generationDomainModule(GenerationDomainModule())
            .generationPresentationModule(GenerationPresentationModule())
            .build()
    }

    private val generationFromTextComponent by lazy {
        DaggerGenerationFromTextComponent
            .builder()
            .generationFromTextDomainModule(GenerationFromTextDomainModule())
            .generationFromTextPresentationModule(GenerationFromTextPresentationModule())
            .generationFromTextDataModule(GenerationFromTextDataModule())
            .build()
    }

    private val generationFromLinkComponent by lazy {
        DaggerGenerationFromLinkComponent
            .builder()
            .generationFromLinkPresentationModule(GenerationFromLinkPresentationModule())
            .generationFromLinkDomainModule(GenerationFromLinkDomainModule())
            .generationFromLinkDataModule(GenerationFromLinkDataModule())
            .build()
    }

    override fun provideGenerationComponent(): GenerationComponent {
        return generationComponent
    }

    override fun provideGenerationFromTextComponent(): GenerationFromTextComponent {
        return generationFromTextComponent
    }

    override fun provideGenerationFromLinkComponent(): GenerationFromLinkComponent {
        return generationFromLinkComponent
    }
}