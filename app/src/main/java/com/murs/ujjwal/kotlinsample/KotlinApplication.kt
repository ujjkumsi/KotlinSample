package com.murs.ujjwal.kotlinsample

/**
 * Created by Ujjwal on 28/06/17.
 */

import android.app.Application
import android.location.LocationManager
import com.murs.ujjwal.kotlinsample.di.component.ApplicationComponent
import com.murs.ujjwal.kotlinsample.di.component.DaggerApplicationComponent
import com.murs.ujjwal.kotlinsample.di.module.ApplicationModule
import javax.inject.Inject


/**
 * Created by loop on 09/12/14.
 */

class KotlinApplication : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var graph: ApplicationComponent
    }

    @Inject
    lateinit var locationManager: LocationManager

    override fun onCreate() {
        super.onCreate()
        graph = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        graph.inject(this)

        println("App: $locationManager")
        //TODO do some other cool stuff here
    }
}