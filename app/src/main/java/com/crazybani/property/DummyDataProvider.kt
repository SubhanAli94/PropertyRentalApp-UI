package com.crazybani.property

import com.crazybani.property.models.PopularPropertyModel
import com.crazybani.property.models.PropertyModel

object DummyDataProvider {

    lateinit var propertiesList: ArrayList<PropertyModel>
    lateinit var popularPropertiesList: ArrayList<PopularPropertyModel>

    fun getPropetiesListing() {
        propertiesList = arrayListOf()
        repeat((0..10).count()) {
            propertiesList.add(getDummyPropertyDataModel(it))
        }
    }

    fun getPopularPropetiesListing() {
        popularPropertiesList = arrayListOf()
        repeat((0..10).count()) {
            popularPropertiesList.add(getDummyPopularPropertyDataModel1(it))
        }
    }

    private fun getDummyPropertyDataModel(index: Int): PropertyModel {
        return if (index % 2 == 0) {
            PropertyModel(
                "https://media-cdn.tripadvisor.com/media/photo-s/02/f5/c5/af/inside-barcelona-apartments.jpg",
                "Red Bay Apartment",
                "$8000/yearly",
                "Yearly",
                "Apartment",
                "1",
                "1",
                "New York Street, London"
            )
        } else {
            return PropertyModel(
                "https://odis.homeaway.com/odis/listing/49185ef7-0c4c-4c5b-8acb-27954b79f864.f10.jpg",
                "Blue Bay Villa",
                "$10000/year",
                "Yearly",
                "Villa",
                "5",
                "3",
                "London Street, New York"
            )
        }
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