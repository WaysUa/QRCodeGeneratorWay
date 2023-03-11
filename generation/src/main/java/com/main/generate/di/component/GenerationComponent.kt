package com.main.generate.di.component

import com.main.generate.di.modules.GenerationDomainModule
import com.main.generate.di.modules.GenerationPresentationModule
import com.main.generate.presentation.ui.GenerationFragment
import dagger.Component

@Component(modules = [
    GenerationDomainModule::class,
    GenerationPresentationModule::class
])
interface GenerationComponent {
    fun inject(generationFragment: GenerationFragment)
}