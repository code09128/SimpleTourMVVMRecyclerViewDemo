package com.example.simplemvvmrecyclerviewdemo.custom.showdata.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.simplemvvmrecyclerviewdemo.R
import com.example.simplemvvmrecyclerviewdemo.util.base.BaseFragment
import com.example.simplemvvmrecyclerviewdemo.util.global.BaseGlobalFunction
import kotlinx.android.synthetic.main.fragment_web_view.*
import kotlinx.android.synthetic.main.item_tool_bar.*

class WebViewFragment : BaseFragment() {
    override fun getContentViewLayoutID(): Int {
        return R.layout.fragment_web_view
    }

    override fun init() {
        setData()
        setToolBar()
    }

    /**設定初始資料*/
    @SuppressLint("SetJavaScriptEnabled")
    private fun setData() {
        val urlString = this.requireArguments().getString("TourURL")
        //webviewSetting
        wv.webViewClient = WebViewClient()
        val webSettings = wv.settings
        webSettings.javaScriptEnabled = true
        wv.loadUrl(urlString)
    }

    /**設定ToolBar功能*/
    private fun setToolBar() {
        ivLang.visibility = View.GONE
        ivBack.setOnClickListener {
            BaseGlobalFunction.removeFragment(requireActivity(),this)
        }
    }
}