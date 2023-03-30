package com.main.generation_from_text.di.component

import com.main.core.di.modules.CoreModule
import com.main.generation_from_text.di.modules.GenerationFromTextDataModule
import com.main.generation_from_text.di.modules.GenerationFromTextDomainModule
import com.main.generation_from_text.di.modules.GenerationFromTextPresentationModule
import com.main.generation_from_text.presentation.ui.GenerationFromTextFragment
import dagger.Component

@Component(modules = [
    GenerationFromTextPresentationModule::class,
    GenerationFromTextDomainModule::class,
    GenerationFromTextDataModule::class,
    CoreModule::class
])
interface GenerationFromTextComponent {
    fun inject(generationFromTextFragment: GenerationFromTextFragment)
}