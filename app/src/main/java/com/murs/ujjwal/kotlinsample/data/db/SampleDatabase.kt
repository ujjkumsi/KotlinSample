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

package com.murs.ujjwal.kotlinsample.data.db

/**
 * Created by Ujjwal on 28/06/17.
 */

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.murs.ujjwal.kotlinsample.data.dao.NewsDao
import com.murs.ujjwal.kotlinsample.data.entity.Task
import com.murs.ujjwal.kotlinsample.data.dao.TaskDao
import com.murs.ujjwal.kotlinsample.data.entity.News

@Database(entities = arrayOf(Task::class, News::class), version = 1)
abstract class SampleDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
//    abstract fun newsDao(): NewsDao
}
