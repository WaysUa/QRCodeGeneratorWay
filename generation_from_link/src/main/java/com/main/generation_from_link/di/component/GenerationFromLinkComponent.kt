package com.main.generation_from_link.di.component

import com.main.core.di.modules.CoreModule
import com.main.generation_from_link.di.modules.GenerationFromLinkDataModule
import com.main.generation_from_link.di.modules.GenerationFromLinkDomainModule
import com.main.generation_from_link.di.modules.GenerationFromLinkPresentationModule
import com.main.generation_from_link.presentation.ui.GenerationFromLinkFragment
import dagger.Component

@Component(modules = [
    GenerationFromLinkPresentationModule::class,
    GenerationFromLinkDomainModule::class,
    GenerationFromLinkDataModule::class,
    CoreModule::class
])
interface GenerationFromLinkComponent {
    fun inject(generationFromLinkFragment: GenerationFromLinkFragment)
}