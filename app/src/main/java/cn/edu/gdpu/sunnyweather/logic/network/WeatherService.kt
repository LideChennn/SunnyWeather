package cn.edu.gdpu.sunnyweather.logic.network

import cn.edu.gdpu.sunnyweather.SunnyWeatherApplication
import cn.edu.gdpu.sunnyweather.logic.model.DailyResponse
import cn.edu.gdpu.sunnyweather.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng: String, @Path("lat") lat:String) : Call<RealtimeResponse>

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat:String) : Call<DailyResponse>

}