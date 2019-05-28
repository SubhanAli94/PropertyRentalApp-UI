package com.crazybani.property

import com.crazybani.property.models.PropertyModel

object DumyDataProvider {

    lateinit var propertiesList: ArrayList<PropertyModel>

    fun getPropetiesListing() {
        propertiesList = arrayListOf()
        repeat((0..10).count()) {
            propertiesList.add(getDummyPropertyDataModel())
        }
    }

    private fun getDummyPropertyDataModel(): PropertyModel {
        return PropertyModel(
            "https://media-cdn.tripadvisor.com/media/photo-s/02/f5/c5/af/inside-barcelona-apartments.jpg",
            "1000 AED",
            "Monthly",
            "Apartment",
            "1",
            "1",
            "Marina Walk"
        )
    }


}