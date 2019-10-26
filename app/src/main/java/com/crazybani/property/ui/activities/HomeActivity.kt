package com.crazybani.property.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crazybani.property.DummyDataProvider
import com.crazybani.property.R
import com.crazybani.property.ui.adapters.AllItemsAdapter
import com.crazybani.property.ui.adapters.OnPropertyItemClickListener
import com.crazybani.property.ui.adapters.PopularItemsAdapter
import com.crazybani.property.utils.isConnectedToInternet
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), OnPropertyItemClickListener {
    override fun onPropertyItemClick(index: Int) {
        var intent = Intent(this, PropertyDetailActivity::class.java)
        intent.putExtra(
            PropertyDetailActivity.PROPERTY_ITEM,
            DummyDataProvider.propertiesList[index]
        )
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        DummyDataProvider.getPopularPropetiesListing()
        DummyDataProvider.getPropetiesListing()

        rv_popular_homeActivity.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rv_popular_homeActivity.adapter =
            PopularItemsAdapter(DummyDataProvider.popularPropertiesList, this)

        rv_allProperties_homeActivity.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        if (isConnectedToInternet())
            rv_allProperties_homeActivity.adapter =
                AllItemsAdapter(DummyDataProvider.propertiesList, this)
    }
}
