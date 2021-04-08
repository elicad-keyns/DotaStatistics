package com.ek.opendota.presentation.mainFragment

import android.util.Log
import com.ek.opendota.data.net.matches.Match
import com.ek.opendota.data.net.player.Player
import com.ek.opendota.data.net.wl.WL
import com.ek.opendota.environment.Factory
import moxy.InjectViewState
import moxy.MvpPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class MainFPresenter: MvpPresenter<IMainFView>() {

    lateinit var playerData: Player

    fun getPlayerDataFromAPI(playerId: String?) {
        Factory.create()
            .getPlayer(playerId)
            .enqueue(object : Callback<Player> {
                override fun onFailure(call: Call<Player>, t: Throwable) {
                    t.localizedMessage?.let { Log.d("MAIN_PRESENTER_EXC", it) }
                }

                override fun onResponse(
                    call: Call<Player>,
                    response: Response<Player>
                ) {
                    Log.d("MAIN_PRESENTER_RESPONSE", response.body().toString())
                    response.body()?.let { viewState.setResultPlayer(it) }
                }
            })
    }

    fun getLastGames(playerId: String?) {
        Factory.create()
            .getMatchesByLimit(playerId, 5)
            .enqueue(object : Callback<List<Match>> {
                override fun onFailure(call: Call<List<Match>>, t: Throwable) {
                    t.localizedMessage?.let { Log.d("MAIN_PRESENTER_EXC", it) }
                }

                override fun onResponse(call: Call<List<Match>>, response: Response<List<Match>>) {
                    Log.d("MAIN_PRESENTER_RESPONSE", response.body().toString())
                    viewState.setLastMatches(response.body())
                }
            })
    }

    fun getPlayerWL(playerId: String?) {
        Factory.create()
            .getPlayerWL(playerId)
            .enqueue(object : Callback<WL> {
                override fun onFailure(call: Call<WL>, t: Throwable) {
                    t.localizedMessage?.let { Log.d("MAIN_PRESENTER_EXC", it) }
                }

                override fun onResponse(call: Call<WL>, response: Response<WL>) {
                    Log.d("MAIN_PRESENTER_RESPONSE", response.body().toString())
                    viewState.setPlayerWL(response.body())
                }
            })
    }

}