package com.crazybani.property.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.crazybani.property.R

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }

    fun backButtonClicked(view: View) {
        finish()
    }
    fun navigateToHomeActivity(view: View) {
        startActivity(Intent(this, HomeActivity::class.java))
        finishAffinity()
    }
}
