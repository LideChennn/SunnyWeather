package cn.edu.gdpu.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import cn.edu.gdpu.sunnyweather.logic.Repository
import cn.edu.gdpu.sunnyweather.logic.model.Place

class PlaceViewModel : ViewModel() {
    fun savePlace(place: Place) = Repository.savePlace(place)
    fun getSavedPlace() = Repository.getSavedPlace()
    fun isPlaceSaved() = Repository.isPlaceSaved()

    private val searchLiveData = MutableLiveData<String>()

    //在PlaceViewModel中定义了⼀个placeList集合，⽤于对界⾯上显示的城市数据进⾏缓存，因为原则上与界⾯相关的数据都应该放到 ViewModel中
    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) {
        Repository.searchPlaces(it)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }
}