package io.kaeawc.sample

import android.app.Application
import io.kaeawc.instagram.Instagram
import io.kaeawc.instagram.InstagramSdk

class SampleApp : Application() {

    lateinit var instagram: InstagramSdk

    override fun onCreate() {
        super.onCreate()

        instagram = Instagram(this)
    }
}
