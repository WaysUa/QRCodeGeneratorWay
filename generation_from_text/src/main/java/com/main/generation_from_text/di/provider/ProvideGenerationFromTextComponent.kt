package com.main.generation_from_text.di.provider

import com.main.generation_from_text.di.component.GenerationFromTextComponent

interface ProvideGenerationFromTextComponent {
    fun provideGenerationFromTextComponent(): GenerationFromTextComponent
}