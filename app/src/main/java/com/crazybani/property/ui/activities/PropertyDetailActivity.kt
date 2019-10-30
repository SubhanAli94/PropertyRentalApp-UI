package com.crazybani.property.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crazybani.property.R
import com.crazybani.property.databinding.ActivityMainBinding
import com.crazybani.property.databinding.ActivityPropertyDetailBinding
import com.crazybani.property.service.models.PropertyModel
import com.crazybani.property.ui.adapters.OtherImagesAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_property_detail.*

class PropertyDetailActivity : AppCompatActivity(), OtherImagesAdapter.OnOtherImageClickListener {
    override fun onOtherImageClick(index: Int) {
        Picasso.get().load(propertyItem.attachedImagesURL[index])
            .placeholder(R.color.colorPorcelain).into(img_property_detailActivity)
    }

    companion object {
        val PROPERTY_ITEM: String = "propertyItem"
    }

    lateinit var propertyItem: PropertyModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding: ActivityPropertyDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_property_detail)

        cl_container_detailActivity.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        if (intent.hasExtra(PROPERTY_ITEM)) {
            propertyItem = intent.getParcelableExtra(PROPERTY_ITEM)
        }

        binding.propertyModel = propertyItem

        with(propertyItem) {
            Picasso.get().load(attachedImagesURL[0])
                .placeholder(R.color.colorPorcelain).into(img_property_detailActivity)
        }

        rv_otherImages_detailActivity.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        var attachedImagesAdapter = OtherImagesAdapter(propertyItem.attachedImagesURL, this)
        rv_otherImages_detailActivity.adapter = attachedImagesAdapter

    }

    fun backButtonClicked(view: View) {
        finish()
    }

    fun onClickRentButton(view: View) {
        Toast.makeText(this, "Rented Out! Enjoy Living!", Toast.LENGTH_SHORT).show()
    }
}
