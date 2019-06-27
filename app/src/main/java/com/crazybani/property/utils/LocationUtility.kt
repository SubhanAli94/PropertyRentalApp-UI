package com.crazybani.property.utils

import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.core.content.ContextCompat
import androidx.databinding.Bindable
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationRequest



class LocationUtility(var context: Context) {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    @Bindable
    fun getCurrentLocation(): String {
        val mLocationRequest = LocationRequest.create()
        mLocationRequest.interval = 60000
        mLocationRequest.fastestInterval = 5000
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
        var currentLocation: String = "United Ar"
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
            PackageManager.PERMISSION_GRANTED
        )
            fusedLocationProviderClient.lastLocation.addOnSuccessListener {
                var geocoder = Geocoder(context)
                var listOfAddresses = geocoder.getFromLocation(it!!.latitude, it!!.longitude, 1)
                currentLocation = listOfAddresses[0].countryName
            }
        return currentLocation
    }
}