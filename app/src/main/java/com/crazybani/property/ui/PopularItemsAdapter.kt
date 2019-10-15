package com.crazybani.property.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.crazybani.property.R
import com.crazybani.property.models.PopularPropertyModel

class PopularItemsAdapter(var popularItems: ArrayList<PopularPropertyModel>) :
    RecyclerView.Adapter<PopularItemsAdapter.PopularItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularItemViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_listing, parent,false)
        return PopularItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return popularItems.size
    }

    override fun onBindViewHolder(holder: PopularItemViewHolder, position: Int) {
        with(holder){
            with(popularItems[position]) {
                img_property.setImageResource(propertyImageDrawable)
                txt_name.text = propertyName
                txt_address.text = propertyAddress
                txt_price.text = propertyPricePerYear
            }
        }
    }

    class PopularItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img_property = itemView.findViewById<ImageView>(R.id.img_house_popularItem)
        var txt_name = itemView.findViewById<TextView>(R.id.txt_homeName_popularItem)
        var txt_price = itemView.findViewById<TextView>(R.id.txt_price_popularItem)
        var txt_address = itemView.findViewById<TextView>(R.id.txt_address_popularItem)
    }
}