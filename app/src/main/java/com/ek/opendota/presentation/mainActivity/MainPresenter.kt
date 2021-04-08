package com.ek.opendota.presentation.mainActivity

import android.util.Log
import com.ek.opendota.data.net.player.Player
import com.ek.opendota.environment.Factory
import moxy.InjectViewState
import moxy.MvpPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class MainPresenter: MvpPresenter<IMainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

//        getDataFromAPI(DEBUG_STEAM_ID)
    }

    private fun getDataFromAPI(playerId: String) {
        Factory.create()
            .getPlayer(playerId)
            .enqueue(object : Callback<Player> {
                override fun onFailure(call: Call<Player>, t: Throwable) {
                    Log.d("MAIN_PRESENTER_EXC", t.localizedMessage!!)
                }

                override fun onResponse(
                    call: Call<Player>,
                    response: Response<Player>
                ) {
                    Log.d("MAIN_PRESENTER_RESPONSE", response.body().toString())
                    print(response.body())
                }
            })
    }
}