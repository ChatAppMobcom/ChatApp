package com.example.chatapplication

import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.getSystemService
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.ktx.messaging

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var textName: EditText
    private lateinit var textPesan: EditText
    private lateinit var buttonKirim: Button
    private var TAG = "ChatApplication"
    private var CHANNEL_ID = "channel_lan"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.web_chat)
        textName = findViewById(R.id.text_name)
        textPesan = findViewById(R.id.text_pesan)
        buttonKirim = findViewById(R.id.button_kirim)

        webView.loadUrl("https://expert-sys-fc.000webhostapp.com/")

        createNotificationChannel()
        getToken()

        buttonKirim.setOnClickListener {
            var name: String = textName.text.toString()
            var pesan: String = textPesan.text.toString()

            webView.loadUrl("https://expert-sys-fc.000webhostapp.com/index.php?nama=" + name + "&chat=" + pesan + "&submit=kirim#")
            Toast.makeText(baseContext, "Pesan dikirim.", Toast.LENGTH_SHORT).show()
            onRestart()
        }
    }

    override fun onRestart() {
        this.recreate()
        super.onRestart()
    }

    private fun getToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.d(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }
            // Get new FCM registration token
            val token = task.result
            val msg = token.toString()

            Log.e(TAG, "Token : $msg")
            //System.out.println("Fetching FCM success: " + token)
            Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
        })

        Firebase.messaging.subscribeToTopic("lan123")
            .addOnCompleteListener { task ->
                val msg = "Success to subscribe"
                if (!task.isSuccessful) {
                    Log.d(TAG, "Failed to subscribe")
                }
                Log.d(TAG, msg)
                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "FirebaseNotificationChannel"
            val descriptionText = "Receive Firebase Notification"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}