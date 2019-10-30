package com.crazybani.property.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.crazybani.property.BR
import com.crazybani.property.R
import com.crazybani.property.service.models.PropertyModel
import com.squareup.picasso.Picasso

class PopularItemsAdapter(
    var popularItems: ArrayList<PropertyModel>,
    var onPropertyItemClickListener: OnPropertyItemClickListener
) :
    RecyclerView.Adapter<PopularItemsAdapter.PopularItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularItemViewHolder {
        var binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_popular_listing,
            parent,
            false
        )
        return PopularItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return popularItems.size
    }

    override fun onBindViewHolder(holder: PopularItemViewHolder, position: Int) {
        with(holder) {
            with(popularItems[position]) {
                Picasso.get().load(propertyImageUrl).into(img_property)
            }
        }

        holder.bind(popularItems[position])

        holder.img_property.setOnClickListener {
            onPropertyItemClickListener.onPropertyItemClick(popularItems[position])
        }
    }

    class PopularItemViewHolder(private val viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(propertyModel: PropertyModel) {
            viewDataBinding.setVariable(BR.propertyModel, propertyModel)
            viewDataBinding.executePendingBindings()
        }

        var img_property = itemView.findViewById<ImageView>(R.id.img_house_popularItem)
    }
}