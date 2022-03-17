package com.mandarjoshi.androidnextgen.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Action(
    @Json(name = "id") var id: String,
    @Json(name = "description") var description: String,
    @Json(name = "date") var date: String,
    @Json(name = "contact_number") var contact_number: String,
    @Json(name = "amount") var amount: String,
    @Json(name = "rating") var rating: String
)