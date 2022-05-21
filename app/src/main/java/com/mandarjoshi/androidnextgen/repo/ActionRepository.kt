package com.mandarjoshi.androidnextgen.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.mandarjoshi.androidnextgen.model.Action

import com.mandarjoshi.androidnextgen.util.Resource
import kotlinx.coroutines.Dispatchers

open class ActionRepository(private val actionService: ActionService) {

    suspend fun getActionList(): List<Action>? {
        return actionService.getActionList()
    }
}
