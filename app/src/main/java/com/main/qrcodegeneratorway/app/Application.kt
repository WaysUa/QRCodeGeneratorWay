package com.main.qrcodegeneratorway.app

import android.app.Application
import com.main.core.database.repository.QRCodeCacheRepository
import com.main.core.database.repository.QRCodeCacheRepositoryImpl
import com.main.core.di.modules.CoreModule
import com.main.favorites.di.component.DaggerFavoritesComponent
import com.main.favorites.di.component.FavoritesComponent
import com.main.favorites.di.modules.FavoritesDomainModule
import com.main.favorites.di.modules.FavoritesPresentationModule
import com.main.favorites.di.provider.ProvideFavoritesComponent
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
import com.main.generation_from_phone.di.component.DaggerGenerationFromPhoneComponent
import com.main.generation_from_phone.di.component.GenerationFromPhoneComponent
import com.main.generation_from_phone.di.modules.GenerationFromPhoneDataModule
import com.main.generation_from_phone.di.modules.GenerationFromPhoneDomainModule
import com.main.generation_from_phone.di.modules.GenerationFromPhonePresentationModule
import com.main.generation_from_phone.di.provider.ProvideGenerationFromPhoneComponent
import com.main.generation_from_text.di.component.DaggerGenerationFromTextComponent
import com.main.generation_from_text.di.component.GenerationFromTextComponent
import com.main.generation_from_text.di.modules.GenerationFromTextDataModule
import com.main.generation_from_text.di.modules.GenerationFromTextDomainModule
import com.main.generation_from_text.di.modules.GenerationFromTextPresentationModule
import com.main.generation_from_text.di.provider.ProvideGenerationFromTextComponent
import com.main.qrcodegeneratorway.data.cloud.QRCodeDatabase

class Application : Application(), ProvideGenerationComponent, ProvideGenerationFromTextComponent,
    ProvideGenerationFromLinkComponent, ProvideGenerationFromPhoneComponent, ProvideFavoritesComponent {

    private lateinit var coreModule: CoreModule

    override fun onCreate() {
        super.onCreate()
        val qrCodeDao = QRCodeDatabase.getInstance(applicationContext).qrCodeDao()
        coreModule = CoreModule(qrCodeDao)
    }

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
            .coreModule(coreModule)
            .build()
    }

    private val generationFromLinkComponent by lazy {
        DaggerGenerationFromLinkComponent
            .builder()
            .generationFromLinkPresentationModule(GenerationFromLinkPresentationModule())
            .generationFromLinkDomainModule(GenerationFromLinkDomainModule())
            .generationFromLinkDataModule(GenerationFromLinkDataModule())
            .coreModule(coreModule)
            .build()
    }

    private val generationFromPhoneComponent by lazy {
        DaggerGenerationFromPhoneComponent
            .builder()
            .generationFromPhoneDataModule(GenerationFromPhoneDataModule())
            .generationFromPhoneDomainModule(GenerationFromPhoneDomainModule())
            .generationFromPhonePresentationModule(GenerationFromPhonePresentationModule())
            .coreModule(coreModule)
            .build()
    }

    private val favoritesComponent by lazy {
        DaggerFavoritesComponent
            .builder()
            .favoritesDomainModule(FavoritesDomainModule())
            .favoritesPresentationModule(FavoritesPresentationModule())
            .coreModule(coreModule)
            .build()
    }

    override fun provideGenerationComponent(): GenerationComponent {
        return generationComponent
    }

    override fun provideGenerationFromLinkComponent(): GenerationFromLinkComponent {
        return generationFromLinkComponent
    }

    override fun provideGenerationFromTextComponent(): GenerationFromTextComponent {
        return generationFromTextComponent
    }

    override fun provideGenerationFromPhoneComponent(): GenerationFromPhoneComponent {
        return generationFromPhoneComponent
    }

    override fun provideFavoritesComponent(): FavoritesComponent {
        return favoritesComponent
    }
}