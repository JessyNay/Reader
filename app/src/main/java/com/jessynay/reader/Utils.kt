package com.jessynay.reader

import android.content.ComponentName
import android.content.Context
import android.provider.Settings

class Utils {
    companion object {
        fun isAssistantEnabled(context: Context): Boolean {
            val selectedAssistant = Settings.Secure.getString(context.contentResolver, "voice_interaction_service")
            var enabled = false

            if (selectedAssistant != null) {
                val assistantComponentName = ComponentName.unflattenFromString(selectedAssistant)
                enabled = assistantComponentName?.packageName == context.packageName
            }

            return enabled
        }
    }
}
