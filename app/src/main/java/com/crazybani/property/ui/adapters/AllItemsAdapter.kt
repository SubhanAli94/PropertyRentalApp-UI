package com.crazybani.property.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.crazybani.property.R
import com.crazybani.property.models.PropertyModel
import com.squareup.picasso.Picasso

class AllItemsAdapter(
    var allItems: ArrayList<PropertyModel>,
    var onPropertyItemClickListener: OnPropertyItemClickListener
) :
    RecyclerView.Adapter<AllItemsAdapter.AllItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllItemViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_property, parent, false)
        return AllItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return allItems.size
    }

    override fun onBindViewHolder(holder: AllItemViewHolder, position: Int) {
        with(holder) {
            with(allItems[position]) {
                Picasso.get().load(propertyImageUrl).into(img_property)
                txt_name.text = propertyName
                txt_price.text = propertyPrice
                txt_address.text = propertyAddress
                txt_propertyType.text = propertyType
                txt_bedCounter.text = numOfBeds
                txt_bathCounter.text = numOfBaths
            }
        }

        holder.container.setOnClickListener {
            onPropertyItemClickListener.onPropertyItemClick(position)
        }
    }

    class AllItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var container = itemView.findViewById<LinearLayout>(R.id.ll_container_propertyItem)
        var img_property = itemView.findViewById<ImageView>(R.id.img_property_propertyItem)
        var txt_name = itemView.findViewById<TextView>(R.id.txt_propertyName_propertyItem)
        var txt_price = itemView.findViewById<TextView>(R.id.txt_propertyPrice_propertyItem)
        var txt_address = itemView.findViewById<TextView>(R.id.txt_propertyAddress_propertyItem)
        var txt_propertyType = itemView.findViewById<TextView>(R.id.txt_propertyType_propertyItem)
        var txt_bedCounter = itemView.findViewById<TextView>(R.id.txt_bedCounter_propertyItem)
        var txt_bathCounter = itemView.findViewById<TextView>(R.id.txt_bathtubCounter_propertyItem)
    }
}