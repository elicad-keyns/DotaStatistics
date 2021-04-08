package com.ek.opendota.presentation.playerFragment

import com.ek.opendota.data.net.player.Player
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface IPlayerView: MvpView {

    fun setResult(player: Player)
}