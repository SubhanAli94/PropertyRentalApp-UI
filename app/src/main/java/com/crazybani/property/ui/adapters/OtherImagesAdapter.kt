package com.crazybani.property.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.crazybani.property.R
import com.squareup.picasso.Picasso

class OtherImagesAdapter(
    var popularItems: ArrayList<String>,
    var onOtherImageClickListener: OnOtherImageClickListener
) :
    RecyclerView.Adapter<OtherImagesAdapter.PopularItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularItemViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_otherr_images, parent, false)
        return PopularItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return popularItems.size
    }

    override fun onBindViewHolder(holder: PopularItemViewHolder, position: Int) {
        with(holder) {
            Picasso.get().load(popularItems[position]).placeholder(R.color.colorPorcelain)
                .into(img_property)
        }

        holder.cardViewContainer.setOnClickListener {
            onOtherImageClickListener.onOtherImageClick(position)
        }
    }

    class PopularItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img_property = itemView.findViewById<ImageView>(R.id.img_otherImageItem)
        var cardViewContainer =
            itemView.findViewById<CardView>(R.id.cardView_container_otherImageItem)
    }

    interface OnOtherImageClickListener {
        fun onOtherImageClick(index: Int)
    }
}