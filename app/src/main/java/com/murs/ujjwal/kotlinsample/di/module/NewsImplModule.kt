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

package com.murs.ujjwal.kotlinsample.di.module

import android.content.Context
import com.murs.ujjwal.kotlinsample.di.api.NewsApiInterface
import com.murs.ujjwal.kotlinsample.ui.activity.MainActivity
import com.murs.ujjwal.kotlinsample.ui.activity.NewsActivity
import com.murs.ujjwal.kotlinsample.util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers

/**
 * Created by Ujjwal on 02/07/17.
 */

@Module class NewsImplModule(private val activity : NewsActivity){

    @Provides fun provideActivity(): NewsActivity = activity

    @Provides fun provideNewApiInterface(): NewsApiInterface {
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.NEWS_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
        return retrofit.create(NewsApiInterface::class.java)
    }
}