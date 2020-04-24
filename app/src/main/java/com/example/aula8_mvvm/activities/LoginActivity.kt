package com.example.aula8_mvvm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula8_mvvm.NavigationManager
import com.example.aula8_mvvm.R

const val EXTRA_USERNAME = "com.example.aula8_mvvm.activities.USERNAME"
const val EXTRA_USER_EMAIL = "com.example.aula8_mvvm.activities.EMAIL"

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        NavigationManager.goToLoginFragment(supportFragmentManager)
    }

}
