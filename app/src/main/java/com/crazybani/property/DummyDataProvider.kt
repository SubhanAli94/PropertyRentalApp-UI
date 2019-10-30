package com.crazybani.property

import com.crazybani.property.service.models.PropertyModel

object DummyDataProvider {

    fun getPropertiesListing(): ArrayList<PropertyModel> {
        var propertiesList = arrayListOf<PropertyModel>()
        repeat((0..10).count()) {
            propertiesList.add(getDummyPropertyDataModel(it))
        }

        return propertiesList
    }

    fun getPopularPropertiesListing(): ArrayList<PropertyModel> {
        var popularPropertiesList = arrayListOf<PropertyModel>()
        repeat((0..5).count()) {
            popularPropertiesList.add(getDummyPropertyDataModel(it))
        }

        return popularPropertiesList
    }

    private fun getDummyPropertyDataModel(index: Int): PropertyModel {
        var attachedImagesList = ArrayList<String>()
        attachedImagesList.add("https://scdn.aro.ie/Sites/50/grantleyhall2018/uploads/images/headerimagessplitscreen47/headerimagesplitscreen32/Grantley_Hall_Deluxe_room_Jack_Hardy_2019.jpg")
        attachedImagesList.add("https://q-cf.bstatic.com/images/hotel/max1024x768/120/120695398.jpg")
        attachedImagesList.add("https://q-cf.bstatic.com/images/hotel/max1024x768/111/111929367.jpg")
        attachedImagesList.add("https://images.pavilionshotels.com/image/fetch/w_670,h_487,c_fill,g_auto,fl_force_strip.immutable_cache.lossy.strip_profile,q_auto:low/https://www.thetoren.nl/image/catalog/amsterdam/Rooms-Suites/cozy-double-room-116.JPG")
        attachedImagesList.add("https://www.trinitycityhotel.com/files/hotel/hotel-a/02-rooms/Deluxe-Room-high-res.jpg")
        attachedImagesList.add("https://cdn.pixabay.com/photo/2018/03/04/09/51/space-3197611__340.jpg")
        attachedImagesList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOehkhGUClxI-CAP3nNSddWf2POoxXb--id-cdJzcwnZhILuT_&s")
        return if (index % 2 == 0) {
            PropertyModel(
                "https://media-cdn.tripadvisor.com/media/photo-s/02/f5/c5/af/inside-barcelona-apartments.jpg",
                "Red Bay Apartment",
                "$8000/year",
                "Yearly",
                "Paradise at The Point! This luxurious 4 bedroom 4.5 bath Dienst-built estate on the Lake Norman peninsula is a dream home in a high-end community that's home to Trump National Golf Club. Spanning over 4900 SF, this magnificent waterfront residence graced by soaring ceilings and wall-to-wall windows is a haven for gazing at Lake Norman views from multiple vantage points. The grand entryway with a sweeping staircase draws you into a voluminous layout made for entertaining. ",
                "Apartment",
                "1",
                "1",
                "2600 sqft",
                "4",
                "1",
                "2",
                "New York Street, London",
                attachedImagesList
            )
        } else {
            PropertyModel(
                "https://odis.homeaway.com/odis/listing/49185ef7-0c4c-4c5b-8acb-27954b79f864.f10.jpg",
                "Blue Bay Villa",
                "$10000/year",
                "Yearly",
                "Paradise at The Point! This luxurious 4 bedroom 4.5 bath Dienst-built estate on the Lake Norman peninsula is a dream home in a high-end community that's home to Trump National Golf Club. Spanning over 4900 SF, this magnificent waterfront residence graced by soaring ceilings and wall-to-wall windows is a haven for gazing at Lake Norman views from multiple vantage points. The grand entryway with a sweeping staircase draws you into a voluminous layout made for entertaining. ",
                "Villa",
                "5",
                "3",
                "2600 sqft",
                "4",
                "1",
                "2",
                "London Street, New York",
                attachedImagesList
            )
        }
    }
}