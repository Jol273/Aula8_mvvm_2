package com.example.aula8_mvvm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula8_mvvm.NavigationManager
import com.example.aula8_mvvm.R

const val EXTRA_USER = "com.example.aula8_mvvm.activities.USER"
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        NavigationManager.goToLoginFragment(supportFragmentManager)
    }

    fun enterCalculator(userInfo: ArrayList<String>){
        val intent = Intent(this,MainActivity::class.java)
        intent.apply { putStringArrayListExtra(EXTRA_USER,userInfo) }
        startActivity(intent)
        finish()
    }

}
