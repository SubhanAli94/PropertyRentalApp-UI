package com.crazybani.property.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import com.crazybani.property.R
import android.text.SpannableString
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import com.crazybani.property.utils.withClickableSpan
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var registerNowString = getString(R.string.registerNow)

        var span = SpannableString(registerNowString)
        span.setSpan(
            object : ClickableSpan() {
                override fun onClick(widget: View) {
                    startActivity(Intent(this@LoginActivity, RegistrationActivity::class.java))
                    finish()
                }
            },
            registerNowString.indexOf("Register now"),
            registerNowString.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        txt_registerNow_loginActivity.text = span
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
