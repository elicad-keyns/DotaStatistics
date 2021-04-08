package com.ek.opendota.presentation.mainFragment

import com.ek.opendota.data.net.matches.Match
import com.ek.opendota.data.net.player.Player
import com.ek.opendota.data.net.wl.WL
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface IMainFView: MvpView {

    fun setResultPlayer(player: Player)

    fun setLastMatches(matches: List<Match>?)

    fun setPlayerWL(wl: WL?)

}