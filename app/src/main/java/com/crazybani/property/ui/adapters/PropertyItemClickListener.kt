package com.crazybani.property.ui.adapters

import com.crazybani.property.service.models.PropertyModel

interface OnPropertyItemClickListener {
    fun onPropertyItemClick(propertyModel: PropertyModel)
}