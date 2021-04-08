package com.ek.opendota.presentation.welcomeActivity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import com.ek.opendota.R
import com.ek.opendota.data.common.DEBUG_STEAM_ID
import com.ek.opendota.presentation.mainActivity.MainActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class WelcomeActivity : MvpAppCompatActivity(R.layout.activity_welcome), IWelcomeView {
    private lateinit var prefs: SharedPreferences

    @InjectPresenter
    lateinit var welcomePresenter: WelcomePresenter

    override fun onStart() {
        super.onStart()
        prefs = getSharedPreferences("dotaId", Context.MODE_PRIVATE)
        if (prefs.contains("DOTA_ID")) {
            val dotaId = loadDotaID()
            openAccountFragment(dotaId)
        }
        setButtonListeners()
    }

    private fun setButtonListeners() {
        bSearch.setOnClickListener {
            if (etDotaId.text?.isNotEmpty() == true && etDotaId.text?.isNotBlank() == true) {
                saveDotaID()
                openAccountFragment(etDotaId.text.toString())
            }
        }
    }

    private fun openAccountFragment(dotaId: String?) {
        val intent = Intent(this, MainActivity::class.java)
        val bundle = Bundle()
        bundle.putString("dotaId", dotaId)
        intent.putExtras(bundle)
        startActivity(intent)
        finish()
    }

    private fun saveDotaID() {
        val editor = prefs.edit()
        editor.putString("DOTA_ID", etDotaId.text.toString()).apply()
    }

    private fun loadDotaID(): String? {
        return prefs.getString("DOTA_ID", DEBUG_STEAM_ID)
    }

}