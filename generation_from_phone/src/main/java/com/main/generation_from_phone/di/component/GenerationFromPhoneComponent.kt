package com.main.generation_from_phone.di.component

import com.main.generation_from_phone.presentation.ui.GenerationFromPhoneFragment
import com.main.generation_from_phone.di.modules.GenerationFromPhoneDataModule
import com.main.generation_from_phone.di.modules.GenerationFromPhoneDomainModule
import com.main.generation_from_phone.di.modules.GenerationFromPhonePresentationModule
import dagger.Component

@Component(modules = [
    GenerationFromPhonePresentationModule::class,
    GenerationFromPhoneDomainModule::class,
    GenerationFromPhoneDataModule::class
])
interface GenerationFromPhoneComponent {
    fun inject(generationFromPhoneFragment: GenerationFromPhoneFragment)
}