package com.example.simplemvvmrecyclerviewdemo.custom.showdata.repository

import com.example.simplemvvmrecyclerviewdemo.custom.showdata.model.TourDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @Headers(
        "Accept: application/json"
    )
    @GET("{lang}/Attractions/All")
    fun index(@Path("lang") lang:String): Call<TourDataModel>
}