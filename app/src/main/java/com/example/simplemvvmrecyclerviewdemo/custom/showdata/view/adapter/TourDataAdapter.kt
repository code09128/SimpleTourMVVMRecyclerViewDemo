package com.example.simplemvvmrecyclerviewdemo.custom.showdata.view.adapter

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.simplemvvmrecyclerviewdemo.R
import com.example.simplemvvmrecyclerviewdemo.custom.showdata.model.Datas
import com.example.simplemvvmrecyclerviewdemo.util.base.BaseRecyclerAdapter

/**
 * @author dustin.hsieh
 * @Date on 2023/10/13
 * @Description ShowDataAdapter
 */
class TourDataAdapter(private var mData: List<Datas>?) : BaseRecyclerAdapter() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.show_data_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        val tvTitle = holder.getView<TextView>(R.id.tv_title)
        tvTitle.text = mData!![position].name

        val tvIntro = holder.getView<TextView>(R.id.tv_intro)
        tvIntro.text = mData!![position].introduction

        val ivImage = holder.getView<ImageView>(R.id.iv_ImageTitle)

        if (mData!![position].images!!.isNullOrEmpty()){
            ivImage.setImageResource(R.drawable.construction)
        } else{
            val strImageUrls = mData!![position].images!![0].src!!

            Glide.with(holder.itemView.context)
                .load(strImageUrls)
                .into(ivImage)
        }
    }

    override fun getItemCount(): Int {
        return mData?.size ?: 0
    }
}