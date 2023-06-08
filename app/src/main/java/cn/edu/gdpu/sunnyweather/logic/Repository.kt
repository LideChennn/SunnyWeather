package cn.edu.gdpu.sunnyweather.logic

import androidx.lifecycle.liveData
import cn.edu.gdpu.sunnyweather.logic.model.Place
import cn.edu.gdpu.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers

object Repository {
    //诸如读写数据库之类的本地数据操作也是不建议在主线程中进⾏的，因此⾮常有必要在仓库层进⾏⼀次线程转换。
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            //这个emit()⽅法其实类似于调⽤LiveData的setValue()⽅法来通知数据变化，
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}