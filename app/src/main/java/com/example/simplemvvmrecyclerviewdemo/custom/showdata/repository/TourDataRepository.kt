package com.example.simplemvvmrecyclerviewdemo.custom.showdata.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.simplemvvmrecyclerviewdemo.RetrofitHelper
import com.example.simplemvvmrecyclerviewdemo.custom.showdata.model.TourDataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author dustin.hsieh
 * @Date on 2023/10/13
 * @Description Repository 是從來源(Source)取得資料加以處理
 */
class TourDataRepository {
    private val TAG = javaClass.simpleName

    /**新增資料*/
    fun fetchTourData(lang:String): MutableLiveData<TourDataModel> {
        val mutableList: MutableLiveData<TourDataModel> = MutableLiveData()

        val apiInterface = RetrofitHelper.getRetrofitClient()?.create(ApiInterface::class.java)

        //異步取資料
        apiInterface?.index(lang)?.enqueue(object : Callback<TourDataModel> {
            override fun onResponse(call: Call<TourDataModel>, response: Response<TourDataModel>) {

                if (response.isSuccessful) {
                    mutableList.postValue(response.body())
                    Log.e(TAG, "onResponse response =" + response.body())
                }
            }

            override fun onFailure(call: Call<TourDataModel>, t: Throwable) {
                Log.e(TAG, "onFailure call=$call")
            }
        })

        return mutableList
    }
}