package com.ek.opendota.presentation.mainFragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.ek.opendota.R
import com.ek.opendota.data.net.matches.Match
import com.ek.opendota.data.net.player.Player
import com.ek.opendota.data.net.wl.WL
import kotlinx.android.synthetic.main.fragment_main.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class MainFragment : MvpAppCompatFragment(R.layout.fragment_main), IMainFView {

    @InjectPresenter
    lateinit var mainFPresenter: MainFPresenter

    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        onGetAccountInfo()
        llAccount.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_playerFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun onGetAccountInfo() {
        val bundle = activity?.intent?.extras
        val dotaId = bundle?.getString("dotaId")
        mainFPresenter.getPlayerDataFromAPI(dotaId)
        mainFPresenter.getPlayerWL(dotaId)
        mainFPresenter.getLastGames(dotaId)
    }

    override fun setResultPlayer(player: Player) {
        this.player = player
        tvPlayerName.text = "Name: ${player.profile?.personaname}"
        tvPlayerMMR.text = "MMR: ${player.mmr_estimate?.estimate.toString()}"
        Glide.with(this).load(player.profile?.avatarfull).into(ivPlayerAvatar)
    }

    override fun setPlayerWL(wl: WL?) {
        tvPlayerWins.text = "Wins: ${wl?.win.toString()}"
        tvPlayerLoses.text = "Loses: ${wl?.lose.toString()}"
    }

    override fun setLastMatches(matches: List<Match>?) {
        if (matches != null) {
            setLastMatch(ivHeroOne, tvKDAOne, matchCardOne, matches[0])
            setLastMatch(ivHeroTwo, tvKDATwo, matchCardTwo, matches[1])
            setLastMatch(ivHeroThree, tvKDAThree, matchCardThree, matches[2])
            setLastMatch(ivHeroFour, tvKDAFour, matchCardFour, matches[3])
            setLastMatch(ivHeroFive, tvKDAFive, matchCardFive, matches[4])
        }
    }

    private fun setLastMatch(iv: ImageView, tv: TextView, card: RelativeLayout, match: Match) {
        iv.setImageDrawable(ContextCompat.getDrawable(requireContext(), getHeroImgByName(match.hero_id)))
        tv.text = match.kills.toString() + "/" + match?.deaths + "/" + match?.assists
        if (match.radiant_win && match.player_slot < 100)
            card.setBackgroundResource(R.drawable.row_win)
        else
            card.setBackgroundResource(R.drawable.row_lose)
    }

    private fun getHeroImgByName(hero_id: Int) =
        when (hero_id) {
            1 -> R.drawable.ic_anti_mage
            2 -> R.drawable.ic_axe
            3 -> R.drawable.ic_bane
            4 -> R.drawable.ic_bloodseeker
            5 -> R.drawable.ic_crystal_mayden
            6 -> R.drawable.ic_drow_ranger
            7 -> R.drawable.ic_earthshaker
            8 -> R.drawable.ic_juggernaut
            9 -> R.drawable.ic_mirana
            10 -> R.drawable.ic_morphling
            11 -> R.drawable.ic_shadow_fiend
            12 -> R.drawable.ic_phantom_lancer
            13 -> R.drawable.ic_puck
            14 -> R.drawable.ic_pudge
            15 -> R.drawable.ic_razor
            16 -> R.drawable.ic_sand_king
            17 -> R.drawable.ic_storm_spirit
            18 -> R.drawable.ic_sven
            19 -> R.drawable.ic_tiny
            20 -> R.drawable.ic_vengeful_spirit
            21 -> R.drawable.ic_windranger
            22 -> R.drawable.ic_zeus
            23 -> R.drawable.ic_kunkka
            24 -> R.drawable.ic_dota
            25 -> R.drawable.ic_lina
            26 -> R.drawable.ic_lion
            27 -> R.drawable.ic_shadow_shaman
            28 -> R.drawable.ic_slardar
            29 -> R.drawable.ic_tidehunter
            30 -> R.drawable.ic_witch_doctor
            31 -> R.drawable.ic_lich
            32 -> R.drawable.ic_riki
            33 -> R.drawable.ic_enigma
            34 -> R.drawable.ic_tinker
            35 -> R.drawable.ic_sniper
            36 -> R.drawable.ic_necrophos
            37 -> R.drawable.ic_warlock
            38 -> R.drawable.ic_beastmaster
            39 -> R.drawable.ic_queen_of_pain
            40 -> R.drawable.ic_venomancer
            41 -> R.drawable.ic_faceless_void
            42 -> R.drawable.ic_skeleton_king
            43 -> R.drawable.ic_death_prophet
            44 -> R.drawable.ic_phantom_assassin
            45 -> R.drawable.ic_pugna
            46 -> R.drawable.ic_templar_assassin
            47 -> R.drawable.ic_viper
            48 -> R.drawable.ic_luna
            49 -> R.drawable.ic_dragon_knight
            50 -> R.drawable.ic_dazzle
            51 -> R.drawable.ic_clockwerk
            52 -> R.drawable.ic_leshrac
            53 -> R.drawable.ic_natures_prophet
            54 -> R.drawable.ic_lifestealer
            55 -> R.drawable.ic_dark_seer
            56 -> R.drawable.ic_clinkz
            57 -> R.drawable.ic_omniknight
            58 -> R.drawable.ic_enchantress
            59 -> R.drawable.ic_huskar
            60 -> R.drawable.ic_night_stalker
            61 -> R.drawable.ic_broodmother
            62 -> R.drawable.ic_bounty_hunter
            63 -> R.drawable.ic_weaver
            64 -> R.drawable.ic_jakiro
            65 -> R.drawable.ic_batrider
            66 -> R.drawable.ic_chen
            67 -> R.drawable.ic_spectre
            68 -> R.drawable.ic_ancient_apparition
            69 -> R.drawable.ic_doom
            70 -> R.drawable.ic_ursa
            71 -> R.drawable.ic_spirit_breaker
            72 -> R.drawable.ic_gyrocopter
            73 -> R.drawable.ic_alchemist
            74 -> R.drawable.ic_invoker
            75 -> R.drawable.ic_silencer
            76 -> R.drawable.ic_outworld_destroyer
            77 -> R.drawable.ic_lycan
            78 -> R.drawable.ic_brewmaster
            79 -> R.drawable.ic_shadow_demon
            80 -> R.drawable.ic_lone_druid
            81 -> R.drawable.ic_chaos_knight
            82 -> R.drawable.ic_meepo
            83 -> R.drawable.ic_treant_protector
            84 -> R.drawable.ic_ogre_magi
            85 -> R.drawable.ic_undying
            86 -> R.drawable.ic_rubick
            87 -> R.drawable.ic_disruptor
            88 -> R.drawable.ic_nyx_assassin
            89 -> R.drawable.ic_naga_siren
            90 -> R.drawable.ic_keeper_of_the_light
            91 -> R.drawable.ic_io
            92 -> R.drawable.ic_visage
            93 -> R.drawable.ic_slark
            94 -> R.drawable.ic_medusa
            95 -> R.drawable.ic_troll_warlord
            96 -> R.drawable.ic_centaur_warrunner
            97 -> R.drawable.ic_magnus
            98 -> R.drawable.ic_timbersaw
            99 -> R.drawable.ic_bristleback
            100 -> R.drawable.ic_tusk
            101 -> R.drawable.ic_skywrath_mage
            102 -> R.drawable.ic_abaddon
            103 -> R.drawable.ic_elder_titan
            104 -> R.drawable.ic_legion_commander
            105 -> R.drawable.ic_techies
            106 -> R.drawable.ic_ember_spirit
            107 -> R.drawable.ic_earth_spirit
            108 -> R.drawable.ic_underlord
            109 -> R.drawable.ic_terrorblade
            110 -> R.drawable.ic_phoenix
            111 -> R.drawable.ic_oracle
            112 -> R.drawable.ic_winter_wyvern
            113 -> R.drawable.ic_arc_warden
            114 -> R.drawable.ic_monkey_king
            115 -> R.drawable.ic_dota
            116 -> R.drawable.ic_dota
            117 -> R.drawable.ic_dota
            118 -> R.drawable.ic_dota
            119 -> R.drawable.ic_dark_willow
            120 -> R.drawable.ic_pangolier
            121 -> R.drawable.ic_grimstroke
            122 -> R.drawable.ic_dota
            123 -> R.drawable.ic_hoodwink
            124 -> R.drawable.ic_dota
            125 -> R.drawable.ic_dota
            126 -> R.drawable.ic_void_spirit
            127 -> R.drawable.ic_dota
            128 -> R.drawable.ic_snapfire
            129 -> R.drawable.ic_mars
            else -> R.drawable.ic_dota
        }
}