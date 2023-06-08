package cn.edu.gdpu.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

//全局变量
class SunnyWeatherApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        //令牌
        const val TOKEN = "OwoKd9CM9Ms6UWmS"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}