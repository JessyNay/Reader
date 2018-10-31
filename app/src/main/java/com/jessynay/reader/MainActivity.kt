package com.jessynay.reader

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateSettingsButton()
        settingsButton.setOnClickListener { startActivity(Intent(Settings.ACTION_VOICE_INPUT_SETTINGS)) }
    }

    override fun onResume() {
        super.onResume()
        updateSettingsButton()
    }

    fun updateSettingsButton() {
        if (Utils.isAssistantEnabled(applicationContext)) {
            settingsButton.visibility = View.GONE
        } else {
            settingsButton.visibility = View.VISIBLE
        }
    }
}
