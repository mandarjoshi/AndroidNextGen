package com.mandarjoshi.androidnextgen.domain

import android.util.Log
import com.mandarjoshi.androidnextgen.model.Vendor
import com.mandarjoshi.androidnextgen.repo.ActionRepository
import com.mandarjoshi.androidnextgen.repo.VendorRepository
import com.mandarjoshi.androidnextgen.viewmodel.ActionUiState
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

class GetActionsUseCase(
    private val actionRepository: ActionRepository,
    private val vendorRepository: VendorRepository) {

    suspend operator fun invoke(): List<ActionUiState> {
        val uiStates = mutableListOf<ActionUiState>()
            val actions = actionRepository.getActionList()
            actions?.let { actionList ->
                for(action in actionList){
                    uiStates.add( ActionUiState(action,vendorRepository.getVendor(action.vendorId)))
                }
            }
        return uiStates
    }
}