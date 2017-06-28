package com.murs.ujjwal.kotlinsample.di.module

/**
 * Created by Ujjwal on 28/06/17.
 */


import android.app.Application
import android.content.Context
import android.location.LocationManager
import com.murs.ujjwal.kotlinsample.di.scope.ForApplication
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * A module for Android-specific dependencies which require a [android.content.Context] or [ ] to create.
 */
@Module
class ApplicationModule(private val application: Application) {

    /**
     * Allow the application context to be injected but require that it be annotated with [ ][ForApplication] to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton
    @ForApplication
    fun provideApplicationContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideLocationManager(): LocationManager {
        return application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    @Provides
    @Singleton
    @Named("something")
    fun provideSomething(): String {
        return "something"
    }

    @Provides
    @Singleton
    @Named("somethingElse")
    fun provideSomethingElse(): String {
        return "somethingElse"
    }

}