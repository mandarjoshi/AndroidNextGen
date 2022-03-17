package com.mandarjoshi.androidnextgen.viewmodel

import com.mandarjoshi.androidnextgen.model.Action

import androidx.lifecycle.*
import com.mandarjoshi.androidnextgen.repo.ActionRepository

import com.mandarjoshi.androidnextgen.util.Resource

private const val BEST_READING_SCORE = 400

class ActionViewModel(private val actionRepository: ActionRepository) : ViewModel() {

    //since caching is not implemented, it is cached here
    private var actionList: List<Action>? = null

    fun getActionList(): LiveData<Resource<List<Action>?>> {
        if (actionList == null) {
            return actionRepository.getActionList()
        }
        return liveData { emit(Resource.success(actionList)) }
    }

    fun refreshActionList(list: Resource<List<Action>?>) {
        actionList = list.data
    }

}
