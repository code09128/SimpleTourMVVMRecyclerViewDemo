package com.example.simplemvvmrecyclerviewdemo.custom.showdata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simplemvvmrecyclerviewdemo.custom.showdata.model.TourDataModel
import com.example.simplemvvmrecyclerviewdemo.custom.showdata.repository.TourDataRepository

/**
 * @author dustin.hsieh
 * @Date on 2020/9/30
 * @Description ViewModel資料處理層
 */
class TourDataViewModel {
    var tourDataRepository:TourDataRepository? = null
    var mutableLiveData:MutableLiveData<TourDataModel>? = null

    init {
        tourDataRepository = TourDataRepository()
    }

    /**
     * LiveData 跟著誰的(Owner 是哪個 Activity 或 Fragment)生命週期
     * 那麼它就會隨著該 Owner 活著或消滅。
     * */
    fun getTourData(lang:String): LiveData<TourDataModel> {
        if (mutableLiveData == null) {
            mutableLiveData = tourDataRepository!!.fetchTourData(lang)
        }
        return mutableLiveData!!
    }
}