package com.ek.opendota.other

import android.app.Application
import com.ek.opendota.data.common.OPEN_DOTA_BASE_URL
import com.ek.opendota.di.DaggerNetworkComponent
import com.ek.opendota.di.NetworkComponent
import com.ek.opendota.di.NetworkModule

class BaseApplication: Application() {

    lateinit var networkComponent: NetworkComponent

    override fun onCreate() {
        super.onCreate()

        networkComponent = DaggerNetworkComponent
            .builder()
            .build()
    }
}