package com.mandarjoshi.androidnextgen.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.mandarjoshi.androidnextgen.model.Vendor

import com.mandarjoshi.androidnextgen.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay

open class VendorRepository(private val vendorService: VendorService) {
    suspend fun getVendor(id: String): Vendor? {
        delay(1000)
        Log.d("mandyjo 6", Thread.currentThread().name)
       return vendorService.getVendor()
    }
}
