package com.crazybani.property.ui.activities

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.crazybani.property.R
import com.crazybani.property.databinding.ActivityMainBinding
import com.crazybani.property.ui.fragments.PropertyListingFragment
import com.crazybani.property.utils.consume
import com.crazybani.property.utils.inTransaction
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener {
    override fun onConnectionFailed(p0: ConnectionResult) {

    }

    override fun onConnected(p0: Bundle?) {

    }

    override fun onConnectionSuspended(p0: Int) {

    }

    lateinit var mLocationRequest: LocationRequest

    companion object {
        var UPDATE_INTERVAL = 5000L
        var FASTEST_INTERVAL = 5000L
    }


    private lateinit var currentFragment: Fragment
    private val REQUEST_PERMISSION_RESULT_CODE = 101
    private val PLAY_SERVICES_RESOLUTION_REQUEST = 102
    private var currentLocation: String = ""
    private lateinit var mGoogleApiClient: GoogleApiClient
    private lateinit var permissions: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        getCurrentLocation()

        binding.location = currentLocation
        setBottomNavigationView()

        //permissions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            permissions = arrayListOf()
            permissions.add(android.Manifest.permission.ACCESS_FINE_LOCATION)
            permissions.add(android.Manifest.permission.ACCESS_COARSE_LOCATION)

            //check which permissions are required to ask
            var permissionsToBeAsked = permissionsRequiredToBeAsked(permissions)
            requestPermissions(permissionsToBeAsked.toTypedArray(), REQUEST_PERMISSION_RESULT_CODE)
        }
    }

    override fun onStart() {
        super.onStart()
        buildGoogleApiClient()
        mGoogleApiClient.connect()
    }

    override fun onResume() {
        super.onResume()
        if (!isPlayServicesInstalled()) {
            Toast.makeText(this, "You need to install Google Play Services to use this app.", Toast.LENGTH_LONG).show()
        }
    }

    override fun onPause() {
        super.onPause()

//        if (mGoogleApiClient != null && mGoogleApiClient.isConnected){
//            LocationServices.getFusedLocationProviderClient(this).removeLocationUpdates()
//        }
    }

    override fun onDestroy() {
        mGoogleApiClient.disconnect()
        super.onDestroy()
    }

    private fun isPlayServicesInstalled(): Boolean {
        var googleApiAvailability = GoogleApiAvailability()
        var resultCode = googleApiAvailability.isGooglePlayServicesAvailable(this)
        if (resultCode != ConnectionResult.SUCCESS) {
            if (googleApiAvailability.isUserResolvableError(resultCode)) {
                googleApiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
            } else {
                finish()
            }
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {

            REQUEST_PERMISSION_RESULT_CODE -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    //process permissions results
                    var missingPermissions = permissionsRequiredToBeAsked(permissions.toCollection(ArrayList()))
                    if (missingPermissions.size > 0) {
                        if (shouldShowRequestPermissionRationale(permissions.get(0))) {
                            showRationale(missingPermissions)
                            return
                        }
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun permissionsRequiredToBeAsked(permissions: ArrayList<String>): ArrayList<String> {

        var resultPermissions = arrayListOf<String>()
        for (permission in permissions) {
            if (!isRequiredToAsk(permission)) {
                resultPermissions.add(permission)
            }
        }
        return resultPermissions
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun isRequiredToAsk(permission: String): Boolean {
        return checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    private fun buildGoogleApiClient() {
        mGoogleApiClient = GoogleApiClient.Builder(this)
            .addApi(LocationServices.API)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .build()
    }

    private fun getCurrentLocation() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(
                    arrayOf(
                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                        android.Manifest.permission.ACCESS_FINE_LOCATION
                    ),
                    REQUEST_PERMISSION_RESULT_CODE
                )
            }
        } else {
//todo            currentLocation = locUtility.getCurrentLocation()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun showRationale(missingPermissions: ArrayList<String>) {
        AlertDialog.Builder(this)
            .setMessage("Location permissions are mandatory to use application. You need to allow application to use it. ")
            .setPositiveButton("OK") { _, _ ->
                run {
                    requestPermissions(
                        missingPermissions.toTypedArray(),
                        REQUEST_PERMISSION_RESULT_CODE
                    )
                }
            }
            .setNegativeButton("Cancel", null)
            .create()
    }

    private fun setBottomNavigationView() {
        bottomNavigation_mainActivity.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.search_menuItem -> consume { replaceFragment(PropertyListingFragment.newInstance()) }
//                R.id.saved_menuItem -> consume { replaceFragment(SavedPropertiesFragment.newInstance()) }
                else -> false
            }
        }

        bottomNavigation_mainActivity.selectedItemId = R.id.search_menuItem
    }

    private fun <F> replaceFragment(fragment: F) where F : Fragment {
        supportFragmentManager.inTransaction {
            currentFragment = fragment
            replace(R.id.frameLayout_mainActivity, fragment)
        }
    }

}
