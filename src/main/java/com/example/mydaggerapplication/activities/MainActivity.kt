package com.example.mydaggerapplication.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mydaggerapplication.R
import com.example.mydaggerapplication.classes.HttpClient
import com.example.mydaggerapplication.components.DaggerAppComponent
import com.example.mydaggerapplication.components.DaggerUserRegistrationComponent
import com.example.mydaggerapplication.dimodules.NetworkModule
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var httpClient: HttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //RegistrationComponent
        DaggerUserRegistrationComponent.builder().build().apply {
            getUserRegistrationService().registerUser("test@mail.com", "1234")
        }

        //AppComponent
        DaggerAppComponent.create().inject(this)
        httpClient.makeRequest()

    }




}