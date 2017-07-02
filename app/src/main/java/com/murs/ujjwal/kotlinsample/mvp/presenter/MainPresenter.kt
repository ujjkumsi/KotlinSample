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

package com.murs.ujjwal.kotlinsample.mvp.presenter

/**
 * Created by Ujjwal on 28/06/17.
 */

import com.murs.ujjwal.kotlinsample.data.Task
import com.murs.ujjwal.kotlinsample.data.TaskDao
import com.murs.ujjwal.kotlinsample.mvp.view.MainPresentation
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(val taskDao: TaskDao) {

    val compositeDisposable = CompositeDisposable()
    var tasks = ArrayList<Task>()

    var presentation: MainPresentation? = null

    fun onCreate(toDoPresentation: MainPresentation) {
        presentation = toDoPresentation
        loadTasks()
    }

    fun onDestroy() {
        compositeDisposable.dispose()
        presentation = null
    }

    fun loadTasks() {
        compositeDisposable.add(taskDao.getAllTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    tasks.clear()
                    tasks.addAll(it)
                    (tasks.size - 1).takeIf { it >= 0 }?.let {
                        presentation?.taskAddedAt(it)
                        presentation?.scrollTo(it)
                    }
                }))

        presentation?.showTasks(tasks)
    }

    fun addNewTask(taskDescription: String) {
        val newTask = Task(description = taskDescription)
        compositeDisposable.add(Observable.fromCallable { taskDao.insertTask(newTask) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe())
    }
}