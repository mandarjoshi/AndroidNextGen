package com.mandarjoshi.androidnextgen.di

import com.mandarjoshi.androidnextgen.repo.ActionService
import dagger.Module
import dagger.Provides

import retrofit2.Retrofit
import com.mandarjoshi.androidnextgen.repo.ActionRepository
import com.mandarjoshi.androidnextgen.viewmodel.ViewModelFactory


@Module
class ApplicationModule {
    @Provides
    fun providesActionService(
        retrofit: Retrofit
    ): ActionService {
        return retrofit.create(ActionService::class.java)
    }

    @Provides
    fun providesActionRepository(actionService: ActionService): ActionRepository {
        return ActionRepository(actionService)
    }

    @Provides
    fun providesViewModelFactory(actionRepository: ActionRepository): ViewModelFactory {
        return ViewModelFactory(actionRepository)
    }
}
