package com.mandarjoshi.androidnextgen.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.mandarjoshi.androidnextgen.repo.ActionRepository

import androidx.lifecycle.ViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val actionRepository: ActionRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(aClass: Class<T>): T {
        return ActionViewModel(actionRepository) as T
    }
}
