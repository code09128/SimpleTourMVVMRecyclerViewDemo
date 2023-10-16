package com.example.simplemvvmrecyclerviewdemo.custom.showdata.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplemvvmrecyclerviewdemo.R
import com.example.simplemvvmrecyclerviewdemo.custom.showdata.model.Datas
import com.example.simplemvvmrecyclerviewdemo.custom.showdata.model.TourDataModel
import com.example.simplemvvmrecyclerviewdemo.custom.showdata.view.adapter.TourDataAdapter
import com.example.simplemvvmrecyclerviewdemo.custom.showdata.viewmodel.TourDataViewModel
import com.example.simplemvvmrecyclerviewdemo.util.global.BaseGlobalFunction
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_tool_bar.*


class TourMainActivity : AppCompatActivity() {
    val TAG = javaClass.simpleName
    var lang = "zh-tw"
    lateinit var tourDataAdapter: TourDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolBar()
        initRecyclerView()
        setData(lang)
    }

    private fun initToolBar() {
        ivBack.visibility = View.GONE

        ivLang.setOnClickListener {
            val langIdList: List<String> = listOf(getString(R.string.zhTw), getString(R.string.zhCn),
                getString(R.string.eng), getString(R.string.ja), getString(R.string.ko), getString(R.string.es)
                , getString(R.string.id), getString(R.string.th), getString(R.string.vi))

            AlertDialog.Builder(this)
                .setTitle(R.string.choiceLang)
                .setCancelable(false)
                .setSingleChoiceItems(langIdList.toTypedArray(), 0) { dialog, which ->
                    when (which) {
                        0 -> {
                            lang = "zh-tw"
                            dialog.dismiss()
                            setData(lang)
                        }
                        1 -> {
                            lang = "zh-cn"
                            dialog.dismiss()
                            setData(lang)
                        }
                        2 -> {
                            lang = "en"
                            dialog.dismiss()
                            setData(lang)
                        }
                        3 -> {
                            lang = "ja"
                            dialog.dismiss()
                            setData(lang)
                        }
                        4 -> {
                            lang = "ko"
                            dialog.dismiss()
                            setData(lang)
                        }
                        5 -> {
                            lang = "es"
                            dialog.dismiss()
                            setData(lang)
                        }
                        6 -> {
                            lang = "id"
                            dialog.dismiss()
                            setData(lang)
                        }
                        7 -> {
                            lang = "th"
                            dialog.dismiss()
                            setData(lang)
                        }
                        8 -> {
                            lang = "iv"
                            dialog.dismiss()
                            setData(lang)
                        }
                    }
                }
                .show()
        }
    }

    /**資料設定顯示*/
    private fun setData(lang:String) {
        val showDataViewModel = TourDataViewModel()

        //observe 的第一個參數 this，就是跟getDataList()回傳的LiveData說跟著當前Activity的生命週期。
        //透過observe可以在非同步的資料取得/處理完成以後，把結果回傳回來，這種就是透過觀察者模式來完成我們的Callback處理。
        showDataViewModel.getTourData(lang).observe(this, object : Observer<TourDataModel> {
            override fun onChanged(currencyData: TourDataModel?) {
                if (currencyData != null) {
                    Log.e(TAG, "observe onChanged()=$currencyData")
                    Log.e(TAG, "observe currencyData.data()=$currencyData.data!!")

                    tourDataAdapter = TourDataAdapter(currencyData.data)
                    r_recyclerview.adapter = tourDataAdapter
                    tourDataAdapter.notifyDataSetChanged()

                    tourDataAdapter.setOnItemClickListener {
                        nextToTourDetail(currencyData.data!![it])
                    }
                }
            }
        })
    }

    /**初始initRecyclerView設定*/
    private fun initRecyclerView() {
        r_recyclerview.setHasFixedSize(true);
        val layoutManager = LinearLayoutManager(this)
        r_recyclerview.layoutManager = layoutManager
        r_recyclerview.itemAnimator = DefaultItemAnimator()
    }

    private fun nextToTourDetail(data: Datas) {
        val bundle = Bundle()
        bundle.putSerializable("Tour", data)
        val tourDetailFrag = TourDetailFragment()
        tourDetailFrag.arguments = bundle
        BaseGlobalFunction.addFragment(this,R.id.fl_container,tourDetailFrag)
    }
}