package com.mandarjoshi.androidnextgen.repo

import com.mandarjoshi.androidnextgen.model.Vendor

import retrofit2.http.GET
import retrofit2.http.Path

interface VendorService {
    @GET("vendors")
    suspend fun getVendor(): Vendor?

}
