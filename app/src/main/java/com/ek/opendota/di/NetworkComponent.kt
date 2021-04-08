package com.ek.opendota.di

import com.ek.opendota.presentation.playerFragment.PlayerFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    fun inject(playerFragment: PlayerFragment)

}