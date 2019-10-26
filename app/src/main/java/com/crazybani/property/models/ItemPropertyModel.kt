package com.crazybani.property.models

import android.graphics.drawable.AnimatedImageDrawable


data class PropertyModel(
    var propertyImageUrl: String,
    var propertyName: String,
    var propertyPrice: String,
    var propertyPriceDuration: String,
    var propertyType: String,
    var numOfBeds: String,
    var numOfBaths: String,
    var propertyAddress: String
)


data class PopularPropertyModel(
    var propertyImageDrawable: Int,
    var propertyPricePerYear: String,
    var propertyName: String,
    var propertyAddress: String
)