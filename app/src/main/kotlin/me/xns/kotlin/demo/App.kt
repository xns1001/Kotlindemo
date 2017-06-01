package me.xns.kotlin.demo

import android.app.Application
import android.content.Context
import me.xns.kotlin.demo.util.Logger

/**
 * Created by xiongningsheng on 2017/6/1.
 */
class App : Application() {
    val logTag = "App"

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Logger.d(logTag, "attachBaseContext")
    }
    override fun onCreate() {
        super.onCreate()
        Logger.d(logTag, "onCreate")
    }
}