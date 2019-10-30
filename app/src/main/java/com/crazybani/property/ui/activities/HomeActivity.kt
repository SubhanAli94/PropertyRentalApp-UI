package com.crazybani.property.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crazybani.property.DummyDataProvider
import com.crazybani.property.R
import com.crazybani.property.service.models.PropertyModel
import com.crazybani.property.ui.adapters.AllItemsAdapter
import com.crazybani.property.ui.adapters.OnPropertyItemClickListener
import com.crazybani.property.ui.adapters.PopularItemsAdapter
import com.crazybani.property.viewmodel.PropertiesViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), OnPropertyItemClickListener {

    override fun onPropertyItemClick(propertyModel: PropertyModel) {
        var intent = Intent(this, PropertyDetailActivity::class.java)
        intent.putExtra(
            PropertyDetailActivity.PROPERTY_ITEM,
            propertyModel
        )
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var viewModel = ViewModelProviders.of(this).get(PropertiesViewModel::class.java)
        initView()
        observeData(viewModel)
    }

    private fun observeData(viewModel: PropertiesViewModel) {
        viewModel.propertiesObservable.observe(this,
            Observer<ArrayList<PropertyModel>> {
                if (it != null) {
                    rv_allProperties_homeActivity.adapter =
                        AllItemsAdapter(it, this)
                }
            })

        viewModel.popularPropertiesObservable.observe(this,
            Observer<ArrayList<PropertyModel>> {
                if (it != null) {
                    rv_popular_homeActivity.adapter =
                        PopularItemsAdapter(it, this)
                }
            })
    }

    private fun initView() {
        rv_popular_homeActivity.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        rv_allProperties_homeActivity.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}
