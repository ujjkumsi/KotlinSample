/*
 * MIT License
 *
 * Copyright (c) 2017 Ujjwal Kumar Singh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.murs.ujjwal.kotlinsample.ui.adapter

/**
 * Created by Ujjwal on 02/07/17.
 */


import android.graphics.Bitmap
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.murs.ujjwal.kotlinsample.R
import com.murs.ujjwal.kotlinsample.data.entity.News
import com.murs.ujjwal.kotlinsample.util.DateUtil


class NewsAdapter : Adapter<NewsAdapter.NewsViewHolder>() {

    private var mDataSource: List<News>? = null

    fun setDataSource(dataSource: List<News>) {
        this.mDataSource = dataSource
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = mDataSource!![position]
        holder.bind(newsItem)
    }


    override fun getItemCount(): Int {
        return mDataSource?.size ?: 0
    }


    class NewsViewHolder internal constructor(itemView: View) : ViewHolder(itemView) {

        var newsItem: News? = null

        private val mImageView: ImageView? by lazy {
            itemView.findViewById(R.id.ivImage) as ImageView?
        }
        private val mHeadLineTextView: TextView? by lazy {
            itemView.findViewById(R.id.tvHeadline) as TextView?
        }
        private val mAgencyTextView: TextView?by lazy {
            itemView.findViewById(R.id.tvAgency) as TextView?
        }
        private val mDateTextView: TextView? by lazy {
            itemView.findViewById(R.id.tvDate) as TextView?
        }
        private val mCaptionTextView: TextView? by lazy {
            itemView.findViewById(R.id.tvCaption) as TextView?
        }

        fun bind(newsItem: News) {
            this.newsItem = newsItem
            mHeadLineTextView!!.text = newsItem.headLine

            if (newsItem.agency == null)
                mAgencyTextView!!.visibility = View.GONE
            else
                mAgencyTextView!!.text = itemView.resources.getString(
                        R.string.view_news_item_agency,
                        newsItem.agency)

            mDateTextView!!.text = DateUtil.formatDate(newsItem.dateLine!!)

            mCaptionTextView!!.text = newsItem.caption

        }
    }

}