package cn.edu.gdpu.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

//status代表请求的状态，places包含⼏个与我们查询的关键字关系度⽐较⾼的地区信息
data class PlaceResponse(val status: String, val places: List<Place>) {
}

//地区名字, 地区经纬度, 地区的地址
data class Place(
    val name: String, val location: Location,
    @SerializedName("formatted_address") val address: String
)

//经度纬度
data class Location(val lng: String, val lat: String)
