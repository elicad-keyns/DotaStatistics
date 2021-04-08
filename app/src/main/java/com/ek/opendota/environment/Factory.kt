package com.ek.opendota.environment

import com.ek.opendota.data.common.OPEN_DOTA_BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Factory {
    fun create(): IOpenDotaAPI {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(OPEN_DOTA_BASE_URL)
            .build()

        return retrofit.create(IOpenDotaAPI::class.java)
    }
}