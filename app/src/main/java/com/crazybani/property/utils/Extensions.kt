package com.crazybani.property.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


inline fun Activity.isConnectedToInternet(): Boolean {
    var connManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return connManager?.activeNetworkInfo.isConnected
}

/** Convenience for callbacks/listeners whose return value indicates an event was consumed. */
inline fun consume(f: () -> Unit): Boolean{
    f()
    return true
}

/**
 * Allows calls like
 *
 * `supportFragmentManager.inTransaction { add(...) }`
 */
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}