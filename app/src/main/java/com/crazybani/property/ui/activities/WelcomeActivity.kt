package com.crazybani.property.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.crazybani.property.R

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

    fun navigateToLoginFormActivity(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    fun navigateToRegistrationForm(view: View){
        startActivity(Intent(this, RegistrationActivity::class.java))
    }
}
