package com.crazybani.property.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.crazybani.property.R

class SplashActivity : AppCompatActivity() {

    private lateinit var mDelayHandler: Handler;
    private val DELAY = 3000L
    private var mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mDelayHandler = Handler()
        mDelayHandler.postDelayed(mRunnable, DELAY)
    }
}
