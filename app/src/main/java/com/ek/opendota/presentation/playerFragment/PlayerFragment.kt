package com.ek.opendota.presentation.playerFragment

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.ek.opendota.R
import com.ek.opendota.data.net.player.Player
import kotlinx.android.synthetic.main.fragment_player.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class PlayerFragment : MvpAppCompatFragment(R.layout.fragment_player), IPlayerView {

    @InjectPresenter
    lateinit var playerPresenter: PlayerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun onGetAccountInfo() {
        shimmerPlayerAccount.visibility = View.VISIBLE
        cvPlayerAccount.visibility = View.GONE
        val bundle = activity?.intent?.extras
        val dotaId = bundle?.getString("dotaId")
        playerPresenter.getDataFromAPI(dotaId)
    }

    override fun onStart() {
        super.onStart()
        onGetAccountInfo()
    }


    override fun setResult(player: Player) {
        Glide.with(requireContext()).load(player.profile?.avatarfull).into(ivAvatar)

        tvAccountId.text = "Account ID: " + player.profile?.account_id.toString()
        tvSteamId.text = "Steam ID: " + player.profile?.steamid
        tvPersonaName.text = "Persona Name: " + player.profile?.personaname
        tvName.text = "Name: " + player.profile?.name
        tvMmr.text = "MMR: " + player.mmr_estimate?.estimate.toString()
        tvSoloCompetitiveRank.text = "Solo Competitive Rank:" + player.solo_competitive_rank
        tvLeaderboardRank.text = "Leaderboard Rank:" + player.leaderboard_rank.toString()
        tvCompetitiveRank.text = "Competitive Rank:" + player.competitive_rank
        tvPlus.text = "Plus:" + player.profile?.plus.toString()
        tvCheese.text = "Cheese:" + player.profile?.last_login

        cvPlayerAccount.visibility = View.VISIBLE
        shimmerPlayerAccount.visibility = View.GONE
    }

}