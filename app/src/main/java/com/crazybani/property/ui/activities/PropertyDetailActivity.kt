package com.crazybani.property.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crazybani.property.R
import com.crazybani.property.models.PropertyModel
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
        setContentView(R.layout.activity_property_detail)
        cl_container_detailActivity.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        if (intent.hasExtra(PROPERTY_ITEM)) {
            propertyItem = intent.getParcelableExtra(PROPERTY_ITEM)
        }

        with(propertyItem) {
            Picasso.get().load(attachedImagesURL[0])
                .placeholder(R.color.colorPorcelain).into(img_property_detailActivity)
            txt_propertyName_detailActivity.text = propertyName
            txt_location_detailActivity.text = propertyAddress
            txt_price_detailActivity.text = propertyPrice
            txt_size_detailActivity.text = size
            txt_beds_detailActivity.text = numOfBeds + " " + getString(R.string.bedrooms)
            txt_kitchens_detailActivity.text = numOfKitchens + " " + getString(R.string.kitchens)
            txt_baths_detailActivity.text = numOfBaths + " " + getString(R.string.bathrooms)
            txt_garage_detailActivity.text = numOfGarages + " " + getString(R.string.garages)
            txt_gardens_detailActivity.text = numOfGardens + " " + getString(R.string.gardens)
            txt_description_detailActivity.text = description
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
