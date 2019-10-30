package com.crazybani.property.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.crazybani.property.BR
import com.crazybani.property.R
import com.crazybani.property.service.models.PropertyModel
import com.squareup.picasso.Picasso

class AllItemsAdapter(
    var allItems: ArrayList<PropertyModel>,
    var onPropertyItemClickListener: OnPropertyItemClickListener
) :
    RecyclerView.Adapter<AllItemsAdapter.AllItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllItemViewHolder {
        var viewDataBinding =
            DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent.context)
                , R.layout.item_property,
                parent,
                false
            )
        return AllItemViewHolder(viewDataBinding)
    }

    override fun getItemCount(): Int {
        return allItems.size
    }

    override fun onBindViewHolder(holder: AllItemViewHolder, position: Int) {
        with(holder) {
            with(allItems[position]) {
                Picasso.get().load(propertyImageUrl).into(img_property)
            }
        }
        holder.container.setOnClickListener {
            onPropertyItemClickListener.onPropertyItemClick(allItems[position])
        }
        holder.bind(allItems[position])
    }


    class AllItemViewHolder(private val viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(item: PropertyModel) {
            viewDataBinding.setVariable(BR.propertyModel, item)
            viewDataBinding.executePendingBindings()
        }

        var container = itemView.findViewById<LinearLayout>(R.id.ll_container_propertyItem)
        var img_property = itemView.findViewById<ImageView>(R.id.img_property_propertyItem)
    }
}