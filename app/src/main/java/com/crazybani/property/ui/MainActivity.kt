package com.crazybani.property.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.crazybani.property.R
import com.crazybani.property.ui.fragments.PropertyListingFragment
import com.crazybani.property.utils.consume
import com.crazybani.property.utils.inTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setBottomNavigationView()
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
