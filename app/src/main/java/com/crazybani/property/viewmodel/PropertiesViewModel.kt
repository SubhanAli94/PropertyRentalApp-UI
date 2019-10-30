package com.crazybani.property.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.crazybani.property.service.models.PropertyModel
import com.crazybani.property.service.repository.PropertiesRepository

class PropertiesViewModel(app: Application) : AndroidViewModel(app) {

    var propertiesObservable: LiveData<ArrayList<PropertyModel>> =
        PropertiesRepository.getInstance().getProperties()

    var popularPropertiesObservable: LiveData<ArrayList<PropertyModel>> =
        PropertiesRepository.getInstance().getProperties()

}