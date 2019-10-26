package com.crazybani.property.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PropertyModel(
    var propertyImageUrl: String,
    var propertyName: String,
    var propertyPrice: String,
    var propertyPriceDuration: String,
    var description: String,
    var propertyType: String,
    var numOfBeds: String,
    var numOfBaths: String,
    var size: String,
    var numOfKitchens: String,
    var numOfGardens: String,
    var numOfGarages: String,
    var propertyAddress: String,
    var attachedImagesURL: ArrayList<String>
) : Parcelable