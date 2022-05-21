package com.mandarjoshi.androidnextgen.viewmodel

import com.mandarjoshi.androidnextgen.model.Action
import com.mandarjoshi.androidnextgen.model.Vendor

data class ActionUiState(
    val action: Action? = null,
    val vendor: Vendor? = null
)