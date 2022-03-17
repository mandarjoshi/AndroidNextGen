package com.mandarjoshi.androidnextgen

import com.mandarjoshi.androidnextgen.repo.ActionRepository
import com.mandarjoshi.androidnextgen.viewmodel.ActionViewModel
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue

import org.junit.Test


class ActionViewModelTest {

    private val actionRepository: ActionRepository = mock()
    private val viewModel: ActionViewModel = ActionViewModel(actionRepository)

}
