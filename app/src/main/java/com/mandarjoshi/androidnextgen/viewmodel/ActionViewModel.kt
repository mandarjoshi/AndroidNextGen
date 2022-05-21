package com.mandarjoshi.androidnextgen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import com.mandarjoshi.androidnextgen.domain.GetActionsUseCase
import com.mandarjoshi.androidnextgen.util.Resource
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.sql.Time

class ActionViewModel(private val actionsUseCase: GetActionsUseCase) : ViewModel() {

    private var _uiState = MutableStateFlow(Resource<List<ActionUiState>>())
    val uiState  = _uiState.asStateFlow()
    private var job: Job? = null
    init {
        fetchActionList()
    }

    private fun fetchActionList() {
        Log.d("mandyjo 1","start...")
        _uiState.update {
            Resource.loading()
        }

        Log.d("mandyjo 2",Thread.currentThread().name)
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            val actions = actionsUseCase()
            _uiState.update {
                Resource.success(actions)
            }
            Log.d("mandyjo 3",Thread.currentThread().name)
        }
    }
}
