package com.crazybani.property.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.crazybani.property.DummyDataProvider
import com.crazybani.property.service.models.PropertyModel

class PropertiesRepository {

    companion object {

        private var instance: PropertiesRepository = PropertiesRepository()

        fun getInstance(): PropertiesRepository {
            return instance
        }
    }

    fun getProperties(): LiveData<ArrayList<PropertyModel>> {
        var data = MutableLiveData<ArrayList<PropertyModel>>()
        data.value = DummyDataProvider.getPropertiesListing()

        return data
    }

    fun getPopularProperties(): LiveData<ArrayList<PropertyModel>> {
        var data = MutableLiveData<ArrayList<PropertyModel>>()
        data.value = DummyDataProvider.getPopularPropertiesListing()

        return data
    }
}