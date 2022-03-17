package com.mandarjoshi.androidnextgen.repo

import com.mandarjoshi.androidnextgen.model.Action

import retrofit2.http.GET

interface ActionService {
    @GET("actions")
    suspend fun getActionList(): List<Action>?
}
