package com.crazybani.property.models

import android.graphics.drawable.AnimatedImageDrawable


data class PropertyModel(
    var propertyImageUrl: String,
    var propertyPrice: String,
    var propertyPriceDuration: String,
    var propertyType: String,
    var numOfRooms: String,
    var numOfBaths: String,
    var address: String
)


data class PopularPropertyModel(
    var propertyImageDrawable: Int,
    var propertyPricePerYear: String,
    var propertyName: String,
    var propertyAddress: String
)