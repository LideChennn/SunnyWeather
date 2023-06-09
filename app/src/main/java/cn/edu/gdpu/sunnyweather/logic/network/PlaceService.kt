package cn.edu.gdpu.sunnyweather.logic.network

import cn.edu.gdpu.sunnyweather.SunnyWeatherApplication
import cn.edu.gdpu.sunnyweather.logic.model.DailyResponse
import cn.edu.gdpu.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.io.LineNumberReader

interface PlaceService {

    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>

}