package com.crazybani.property

import com.crazybani.property.models.PopularPropertyModel
import com.crazybani.property.models.PropertyModel

object DumyDataProvider {

    lateinit var propertiesList: ArrayList<PropertyModel>
    lateinit var popularPropertiesList: ArrayList<PopularPropertyModel>

    fun getPropetiesListing() {
        propertiesList = arrayListOf()
        repeat((0..10).count()) {
            propertiesList.add(getDummyPropertyDataModel())
        }
    }

    fun getPopularPropetiesListing() {
        popularPropertiesList = arrayListOf()
        repeat((0..10).count()) {
            popularPropertiesList.add(getDummyPopularPropertyDataModel1(it))
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

    private fun getDummyPopularPropertyDataModel1(index: Int): PopularPropertyModel {

        return if (index % 2 == 0) {
            PopularPropertyModel(
                R.drawable.popular_house_1,
                "$30000/yr",
                "Red House",
                "New York Street, London"
            )
        } else {
            PopularPropertyModel(
                R.drawable.popular_house_2,
                "$40000/yr",
                "Blue House",
                "London Street, New York"
            )
        }
    }


}