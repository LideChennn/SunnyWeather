package cn.edu.gdpu.sunnyweather.logic.dao

import android.content.Context
import androidx.core.content.edit
import cn.edu.gdpu.sunnyweather.SunnyWeatherApplication
import cn.edu.gdpu.sunnyweather.logic.model.Place
import com.google.gson.Gson

object PlaceDao {
    fun savePlace(place: Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavedPlace() : Place {
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")

    private fun sharedPreferences() = SunnyWeatherApplication
        .context
        .getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
}