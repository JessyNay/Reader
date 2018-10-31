package com.jessynay.reader

import android.content.Context
import android.service.voice.VoiceInteractionSession
import android.view.View

class AssistInteractionSession internal constructor(context: Context) : VoiceInteractionSession(
    context
) {
    override fun onCreateContentView(): View {
        return layoutInflater.inflate(R.layout.interaction_session, null)
    }
}