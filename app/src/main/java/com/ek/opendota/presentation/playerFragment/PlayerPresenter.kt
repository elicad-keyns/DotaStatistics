package com.ek.opendota.presentation.playerFragment

import android.util.Log
import com.ek.opendota.data.net.player.Player
import com.ek.opendota.environment.Factory
import moxy.InjectViewState
import moxy.MvpPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class PlayerPresenter: MvpPresenter<IPlayerView>() {

    fun getDataFromAPI(playerId: String?) {
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
                    viewState.setResult(response.body()!!)
                    response.body()?.let { viewState.setResult(it) }
                }
            })
    }
}