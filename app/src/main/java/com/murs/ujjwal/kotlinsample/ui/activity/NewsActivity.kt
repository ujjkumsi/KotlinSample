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

package com.murs.ujjwal.kotlinsample.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.murs.ujjwal.kotlinsample.R
import kotlinx.android.synthetic.main.activity_news.*
import com.murs.ujjwal.kotlinsample.data.entity.News
import com.murs.ujjwal.kotlinsample.di.api.NewsApiInterface
import com.murs.ujjwal.kotlinsample.mvp.presenter.NewsPresenter
import com.murs.ujjwal.kotlinsample.mvp.view.NewsPresentation
import com.murs.ujjwal.kotlinsample.ui.adapter.NewsAdapter
import dagger.android.AndroidInjection
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Ujjwal on 02/07/17.
 */


class NewsActivity: AppCompatActivity() {


//    @Inject
//    lateinit var mNewsPresenter: NewsPresenter
//    @Inject
//    lateinit var mNewsAPI: NewsApiInterface
//
//    private val mNewsAdapter = NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)
//        prepareSwipeRefreshLayout()
//        prepareRecyclerView()
//        rvNews.adapter = mNewsAdapter
//        mNewsPresenter.setNewsApiInterface(mNewsAPI)
//        mNewsPresenter.onViewCreated(this)
//        mNewsPresenter.loadNews()
    }

//    private fun prepareSwipeRefreshLayout() {
//        slView.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW)
//        slView.setOnRefreshListener(this)
//    }
//
//    private fun prepareRecyclerView() {
//        val layoutManager = LinearLayoutManager(this)
//        rvNews.layoutManager = layoutManager
//        rvNews.setHasFixedSize(true)
//    }
//
//    override fun onNewsItemLoaded(newsItems: List<News>) {
//        slView.isRefreshing = false
//        slView.visibility = View.GONE
//        if(newsItems.isEmpty()) {
//            tvStatus.setText(R.string.list_is_empty)
//            return
//        }
//        tvStatus.text = null
//        mNewsAdapter.setDataSource(newsItems)
//    }
//
//    override fun onError(throwable: Throwable?) {
//        slView.isRefreshing = false
//        pbProgress.visibility = View.GONE
//        if (throwable is IOException) {
//            tvStatus.setText(R.string.connection_error)
//        } else {
//            tvStatus.setText(R.string.list_is_empty)
//        }
//    }
//
//    override fun showLoading() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun hideLoading() {
//        slView.isRefreshing = false
//        slView.visibility = View.GONE
//    }
//
//    override fun onRefresh() {
//        mNewsPresenter.loadNews()
//    }
//
//    override fun onStop() {
//        super.onStop()
//        mNewsPresenter.onDestroy()
//    }
}