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

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.murs.ujjwal.kotlinsample.R
import com.murs.ujjwal.kotlinsample.data.entity.Task
import kotlinx.android.synthetic.main.activity_main.*
import com.murs.ujjwal.kotlinsample.ui.adapter.TaskAdapter
import com.murs.ujjwal.kotlinsample.mvp.view.MainPresentation
import com.murs.ujjwal.kotlinsample.mvp.presenter.MainPresenter
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainPresentation {

    @Inject lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvTasks?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTasks?.adapter = TaskAdapter(emptyList())

        btnAdd?.setOnClickListener({ presenter.addNewTask(etTask?.text.toString()) })
        btnNews?.setOnClickListener({val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)})
        presenter.onCreate(this)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showTasks(tasks: List<Task>) {
        rvTasks?.adapter = TaskAdapter(tasks)
    }

    override fun taskAddedAt(position: Int) {
        rvTasks?.adapter?.notifyItemInserted(position)
    }

    override fun scrollTo(position: Int) {
        rvTasks?.smoothScrollToPosition(position)
    }
}
