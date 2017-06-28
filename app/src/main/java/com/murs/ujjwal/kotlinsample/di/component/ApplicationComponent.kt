package com.murs.ujjwal.kotlinsample.di.component

/**
 * Created by Ujjwal on 28/06/17.
 */



import com.murs.ujjwal.kotlinsample.KotlinApplication
import com.murs.ujjwal.kotlinsample.MainActivity
import com.murs.ujjwal.kotlinsample.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by loop on 14/12/14.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application: KotlinApplication)

    fun inject(mainActivity: MainActivity)
}