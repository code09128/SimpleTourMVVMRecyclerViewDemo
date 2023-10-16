package com.example.simplemvvmrecyclerviewdemo.util.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @author dustin.hsieh
 * @Date on 2023/10/13
 * @Description BaseFragment封裝
 */
abstract class BaseFragment:Fragment() {
    /**獲取元件ID*/
    abstract fun getContentViewLayoutID(): Int
    /**初始化資料*/
    abstract fun init()

    /**建立頁面前該初始化的東西*/
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getContentViewLayoutID(), container, false)

        return if (getContentViewLayoutID() != 0){
            view
        } else{
            super.onCreateView(inflater, container, savedInstanceState)
        }
    }

    /**頁面建立後該處理的事件*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}