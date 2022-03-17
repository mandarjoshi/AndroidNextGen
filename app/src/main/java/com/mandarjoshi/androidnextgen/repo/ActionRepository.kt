package com.mandarjoshi.androidnextgen.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.mandarjoshi.androidnextgen.model.Action

import com.mandarjoshi.androidnextgen.util.Resource
import kotlinx.coroutines.Dispatchers

open class ActionRepository(private val actionService: ActionService) {

    fun getActionList(): LiveData<Resource<List<Action>?>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            try {
                emit(Resource.success(data=actionService.getActionList()))
            }catch (exception: Exception){
                emit(Resource.error(data=null,message = "Error"))
            }
        }
    }
}
