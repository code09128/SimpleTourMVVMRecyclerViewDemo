package com.example.simplemvvmrecyclerviewdemo.custom.showdata.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

/**
 * @author dustin.hsieh
 * @Date on 2023/10/13
 * @Description
 */
@Parcelize
data class TourDataModel(
    var data:List<Datas>?
): Parcelable

@Parcelize
data class Datas(
    var id: Int?, //id
    var name: String?, //名稱
    var introduction: String?, //介紹
    var open_time: String?, //開放時間
    var address: String?,
    var tel: String?,
    var url: String?,
    var images:List<ImageURL>?
): Parcelable, Serializable

@Parcelize
data class ImageURL(
    var src: String?,
    var ext: String?
): Parcelable, Serializable