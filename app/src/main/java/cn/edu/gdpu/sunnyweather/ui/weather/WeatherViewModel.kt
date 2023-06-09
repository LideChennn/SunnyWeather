package cn.edu.gdpu.sunnyweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import cn.edu.gdpu.sunnyweather.logic.Repository
import cn.edu.gdpu.sunnyweather.logic.model.Location

class WeatherViewModel : ViewModel() {

    // 界面相关数据
    var locationLng = ""
    var locationLat = ""
    var placeName = ""


    private val locationLiveData = MutableLiveData<Location>()

    val weatherLiveData = Transformations.switchMap(locationLiveData) {location ->
        Repository.refreshWeather(location.lng, location.lat)
    }

    fun refreshWeather(lng: String, lat: String) {
        locationLiveData.value = Location(lng, lat)
    }

}