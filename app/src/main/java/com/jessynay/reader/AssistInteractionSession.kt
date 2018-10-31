package com.jessynay.reader

import android.app.assist.AssistContent
import android.app.assist.AssistStructure
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.Settings
import android.service.voice.VoiceInteractionSession
import android.util.Log
import android.view.View
import android.widget.Toast

class AssistInteractionSession internal constructor(context: Context) : VoiceInteractionSession(
    context
) {
    override fun onCreateContentView(): View {
        return layoutInflater.inflate(R.layout.interaction_session, null)
    }

    override fun onHandleAssist(data: Bundle?, structure: AssistStructure?, content: AssistContent?) {
        super.onHandleAssist(data, structure, content)
        Log.d(AssistInteractionSession::class.java.simpleName, "onHandleAssist")

        if (userDisabledShowContext and VoiceInteractionSession.SHOW_WITH_ASSIST != 0) {
            Toast.makeText(context, context.getString(R.string.verify_permission),
                Toast.LENGTH_LONG).show()

            context.startActivity(Intent(Settings.ACTION_VOICE_INPUT_SETTINGS))
        }
    }

    override fun onHandleAssistSecondary(data: Bundle?, structure: AssistStructure?, content: AssistContent?, index: Int, count: Int) {
        super.onHandleAssistSecondary(data, structure, content, index, count)
        Log.d(AssistInteractionSession::class.java.simpleName, "onHandleAssistSecondary")
    }

    override fun onHandleScreenshot(screenshot: Bitmap?) {
        super.onHandleScreenshot(screenshot)
        Log.d(AssistInteractionSession::class.java.simpleName, "onHandleScreenshot")
    }
}