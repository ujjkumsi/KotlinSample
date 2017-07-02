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

package com.murs.ujjwal.kotlinsample.data.dao

import android.arch.persistence.room.*
import com.murs.ujjwal.kotlinsample.data.entity.News

/**
 * Created by Ujjwal on 02/07/17.
 */

@Dao interface NewsDao {

//    @Query("select * from news")
//    fun getAllNews(): List<News>
//
//    @Query("select * from news where newsItemId = :p0")
//    fun findNewsById(id: Long): News
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertNews(news: News)
//
//    @Update(onConflict = OnConflictStrategy.REPLACE)
//    fun updateNews(news: News)
//
//    @Delete
//    fun deleteNews(news: News)
}