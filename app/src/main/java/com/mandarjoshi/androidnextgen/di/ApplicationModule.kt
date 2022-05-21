package com.mandarjoshi.androidnextgen.di

import com.mandarjoshi.androidnextgen.domain.GetActionsUseCase
import com.mandarjoshi.androidnextgen.repo.ActionService
import dagger.Module
import dagger.Provides

import retrofit2.Retrofit
import com.mandarjoshi.androidnextgen.repo.ActionRepository
import com.mandarjoshi.androidnextgen.repo.VendorRepository
import com.mandarjoshi.androidnextgen.repo.VendorService
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
    fun providesVendorService(
        retrofit: Retrofit
    ): VendorService {
        return retrofit.create(VendorService::class.java)
    }

    @Provides
    fun providesActionRepository(actionService: ActionService): ActionRepository {
        return ActionRepository(actionService)
    }

    @Provides
    fun providesVendorRepository(vendorService: VendorService): VendorRepository {
        return VendorRepository(vendorService)
    }

    @Provides
    fun providesGetActionUseCase(
        actionRepository: ActionRepository,
        vendorRepository: VendorRepository
    ): GetActionsUseCase {
        return GetActionsUseCase(actionRepository, vendorRepository)
    }

    @Provides
    fun providesViewModelFactory(actionsUseCase: GetActionsUseCase): ViewModelFactory {
        return ViewModelFactory(actionsUseCase)
    }
}
