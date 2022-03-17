package com.mandarjoshi.androidnextgen.di

import com.mandarjoshi.androidnextgen.ui.ActionFragment
import com.mandarjoshi.androidnextgen.ui.ActionDetailsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ApplicationModule::class])
interface ApplicationComponent {
    fun inject(actionFragment: ActionFragment)
    fun inject(actionDetailsFragment: ActionDetailsFragment)
}
