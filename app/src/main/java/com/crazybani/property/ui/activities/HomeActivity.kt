package com.crazybani.property.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crazybani.property.DumyDataProvider
import com.crazybani.property.R
import com.crazybani.property.ui.PopularItemsAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        DumyDataProvider.getPopularPropetiesListing()

        rv_popular_homeActivity.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        rv_popular_homeActivity.adapter = PopularItemsAdapter(DumyDataProvider.popularPropertiesList)
    }
}
