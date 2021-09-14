package com.support.delightsdk

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.support.delight_assistant.core.presentation.Assistant
import com.support.delightsdk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Assistant.OnFragmentInteractionListener {

    private val TAG = "MainActivity"
    private lateinit var assistant: Assistant
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assistant = Assistant.Builder()
            .setWebhookUrl("webhook/android/21a948ac-e835-48c6-b37c-b45257e3b6d2/")
            .build()

        showDialog()
    }
    fun showDialog() {
        assistant.show(supportFragmentManager, assistant.tag)
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("Not yet implemented")
    }
}