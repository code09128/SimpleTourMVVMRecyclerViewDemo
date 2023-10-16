package com.example.simplemvvmrecyclerviewdemo.custom.showdata.view

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.simplemvvmrecyclerviewdemo.R
import com.example.simplemvvmrecyclerviewdemo.custom.showdata.model.Datas
import com.example.simplemvvmrecyclerviewdemo.util.base.BaseFragment
import com.example.simplemvvmrecyclerviewdemo.util.global.BaseGlobalFunction
import kotlinx.android.synthetic.main.fragment_tour_detail.*
import kotlinx.android.synthetic.main.item_tool_bar.*

class TourDetailFragment : BaseFragment() {

    override fun getContentViewLayoutID(): Int {
        return R.layout.fragment_tour_detail
    }

    override fun init() {
        setData()
        setToolBar()
    }

    /**設定ToolBar功能*/
    private fun setToolBar() {
        ivLang.visibility = View.GONE
        ivBack.setOnClickListener {
            BaseGlobalFunction.removeFragment(requireActivity(),this)
        }
    }

    /**設定初始資料*/
    private fun setData() {
        val myValue = this.requireArguments().getSerializable("Tour")
        val dataModel:Datas = myValue as Datas

        if (dataModel.images!!.isNullOrEmpty()){
            ivPhoto.setImageResource(R.drawable.construction)
        } else{
            Glide.with(this)
                .load(dataModel.images!![0].src!!)
                .into(ivPhoto)
        }

        tvTourTitle.text = dataModel.name
        tvTourIntro.text = dataModel.introduction
        tvAddress.text = dataModel.address
        tvTel.text = dataModel.tel
        tvURL.text = dataModel.url

        tvURL.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("TourURL", dataModel.url)
            val wbFragment = WebViewFragment()
            wbFragment.arguments = bundle
            BaseGlobalFunction.addFragment(requireActivity(),R.id.fragment_container,wbFragment)
        }
    }
}