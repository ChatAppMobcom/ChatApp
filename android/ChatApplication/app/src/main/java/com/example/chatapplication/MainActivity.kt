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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapplication.adapters.ChatAdapter
import com.example.chatapplication.models.Chat
import com.example.chatapplication.services.ApiService
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.ktx.messaging
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    //private lateinit var textName: EditText
    private lateinit var textPesan: EditText
    private lateinit var buttonKirim: Button
    private var TAG = "ChatApplication"
    private var CHANNEL_ID = "channel_lan"
    lateinit var token: String

    // 29
    private lateinit var recyclerView: RecyclerView

    private var lani_m: String = "eizg0lRbQvG68loSiYT05Q:APA91bETJKa4cd_gB2zpvEZr2n90X8foQ-f6N1QEl51PYEcaiALLixR4fSXWhpMvzmKjptUmIO2btVbWAee--mHqffYLn-jg4-PrTsADq_I0DJki-QC34WdpvNM7ON9gYZhipkbqLd31"
    private var siti_l: String = "fcrtTDHySh6l2Ll-eli4gt:APA91bFgeK2QtUrRMn2Rqi-I5ny5Sf_-BtvE4ANsetH0n3MhW2ADh6tK69YHVa0pwQy1sY1BhHmG_meNBETrce7zegfdXHrVSsU1OJgGPweRLboOBM9NM5AhVx6QFVQ0xuz0Z5QmXQif"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.web_chat)
        //textName = findViewById(R.id.text_name)
        textPesan =
 findViewById(R.id.text_pesan)
        buttonKirim = findViewById(R.id.button_kirim)

        // 29
        recyclerView = findViewById(R.id.recycler_chat)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://expert-sys-fc.000webhostapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.fetchAllChats().enqueue(object: Callback<List<Chat>> {
            override fun onResponse(call: Call<List<Chat>>, response: Response<List<Chat>>) {
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<Chat>>, t: Throwable) {
                Log.d(TAG, "OnFailure")
            }

        })

        // ga kepake, invisible
        webView.loadUrl("https://expert-sys-fc.000webhostapp.com/")
        //webView.settings.javaScriptEnabled = true

        createNotificationChannel()
        getToken()

        buttonKirim.setOnClickListener {
            //var name: String = textName.text.toString()
            var pesan: String = textPesan.text.toString()

            if (token == lani_m) {
                webView.loadUrl("https://expert-sys-fc.000webhostapp.com/index.php?nama=Lani" + "&chat=" + pesan + "&submit=kirim#")
                Toast.makeText(baseContext, "Pesan dikirim.", Toast.LENGTH_SHORT).show()
                onRestart()
            }
            if (token == siti_l) {
                webView.loadUrl("https://expert-sys-fc.000webhostapp.com/index.php?nama=Siti" + "&chat=" + pesan + "&submit=kirim#")
                Toast.makeText(baseContext, "Pesan dikirim.", Toast.LENGTH_SHORT).show()
                onRestart()
            }
            else {
                Toast.makeText(baseContext, "Something went wrong.", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "User invalid.")
            }
        }
    }

    private fun showData(chat: List<Chat>) {
        recyclerView.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ChatAdapter(chat, token)
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
            token = task.result.toString()
            val msg = token

            Log.e(TAG, "Token : $msg")
            System.out.println("Fetching FCM success: " + token)
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