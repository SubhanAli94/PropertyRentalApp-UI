package com.crazybani.property.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.crazybani.property.R
import com.crazybani.property.models.PropertyModel
import com.squareup.picasso.Picasso

class PopularItemsAdapter(
    var popularItems: ArrayList<PropertyModel>,
    var onPropertyItemClickListener: OnPropertyItemClickListener
) :
    RecyclerView.Adapter<PopularItemsAdapter.PopularItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularItemViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_popular_listing, parent, false)
        return PopularItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return popularItems.size
    }

    override fun onBindViewHolder(holder: PopularItemViewHolder, position: Int) {
        with(holder) {
            with(popularItems[position]) {
                Picasso.get().load(propertyImageUrl).into(img_property)
                txt_name.text = propertyName
                txt_address.text = propertyAddress
                txt_price.text = propertyPrice
            }
        }

        holder.img_property.setOnClickListener {
            onPropertyItemClickListener.onPropertyItemClick(position)
        }
    }

    class PopularItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img_property = itemView.findViewById<ImageView>(R.id.img_house_popularItem)
        var txt_name = itemView.findViewById<TextView>(R.id.txt_homeName_popularItem)
        var txt_price = itemView.findViewById<TextView>(R.id.txt_price_popularItem)
        var txt_address = itemView.findViewById<TextView>(R.id.txt_address_popularItem)
    }
}