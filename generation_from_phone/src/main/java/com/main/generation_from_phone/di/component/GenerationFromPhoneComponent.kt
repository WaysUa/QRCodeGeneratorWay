package com.main.generation_from_phone.di.component

import com.main.core.di.modules.CoreModule
import com.main.generation_from_phone.di.modules.GenerationFromPhoneDataModule
import com.main.generation_from_phone.di.modules.GenerationFromPhoneDomainModule
import com.main.generation_from_phone.di.modules.GenerationFromPhonePresentationModule
import com.main.generation_from_phone.presentation.ui.GenerationFromPhoneFragment
import dagger.Component

@Component(modules = [
    GenerationFromPhonePresentationModule::class,
    GenerationFromPhoneDomainModule::class,
    GenerationFromPhoneDataModule::class,
    CoreModule::class
])
interface GenerationFromPhoneComponent {
    fun inject(generationFromPhoneFragment: GenerationFromPhoneFragment)
}