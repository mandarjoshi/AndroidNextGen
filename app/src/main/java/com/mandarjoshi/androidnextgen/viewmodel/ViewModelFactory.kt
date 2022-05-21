package com.mandarjoshi.androidnextgen.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.mandarjoshi.androidnextgen.repo.ActionRepository

import androidx.lifecycle.ViewModel
import com.mandarjoshi.androidnextgen.domain.GetActionsUseCase

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val actionsUseCase: GetActionsUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(aClass: Class<T>): T {
        return ActionViewModel(actionsUseCase) as T
    }
}
