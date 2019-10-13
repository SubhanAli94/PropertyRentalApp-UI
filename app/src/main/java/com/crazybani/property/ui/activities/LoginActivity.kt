package com.crazybani.property.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import com.crazybani.property.R
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.crazybani.property.utils.withClickableSpan
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var registerNowString = getString(R.string.registerNow)


        initForgotPasswordDialog()

        initRegisterNow(registerNowString)
    }


    override fun onBackPressed() {
        super.onBackPressed()
    }

    fun openForgotPasswordDialog(view: View) {
        dialog.show()
    }

    private fun initRegisterNow(registerNowString: String) {
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
        txt_registerNow_loginActivity.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun initForgotPasswordDialog() {
        dialog = AlertDialog.Builder(this).create()
        var dialogView = this.layoutInflater.inflate(R.layout.forgot_password_dialog, null)
        var button = dialogView.findViewById<Button>(R.id.btn_sendMeLink_forgotPassword_dialog)
        button.setOnClickListener {
            Toast.makeText(this, "Email sent successfully!", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.setView(dialogView)
    }
}
