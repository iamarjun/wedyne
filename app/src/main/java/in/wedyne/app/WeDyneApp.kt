package `in`.wedyne.app

import androidx.multidex.MultiDexApplication

class WeDyneApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        Thread.sleep(3000)
    }
}