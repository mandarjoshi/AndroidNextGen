package com.mandarjoshi.androidnextgen

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
            .newBuilder()
            .addHeader("scenario","default")
            .addHeader("projectName","androidnextgen")
            .build()
        return chain.proceed(request)
    }

}