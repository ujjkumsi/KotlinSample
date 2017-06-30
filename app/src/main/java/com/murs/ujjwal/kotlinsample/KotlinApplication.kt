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

package com.murs.ujjwal.kotlinsample

/**
 * Created by Ujjwal on 28/06/17.
 */

import android.app.Activity
import android.app.Application
import com.murs.ujjwal.kotlinsample.di.component.ApplicationComponent
import com.murs.ujjwal.kotlinsample.di.component.DaggerApplicationComponent
import com.murs.ujjwal.kotlinsample.di.module.ApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class KotlinApplication : Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(applicationContext)).build()

        applicationComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

}