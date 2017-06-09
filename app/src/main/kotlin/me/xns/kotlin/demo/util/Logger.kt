package me.xns.kotlin.demo.util

import android.util.Log

/**
 * Created by xiongningsheng on 2017/6/1.
 */

object Logger {

    const val LOG_DEFAULT_TAG = "kotlin-demo"
    const val LOG_LEVEL_VARBOSE: Int = 5
    const val LOG_LEVEL_DEBUG: Int = 4
    const val LOG_LEVEL_INFO: Int = 3
    const val LOG_LEVEL_ERROR: Int = 2
    const val LOG_LEVEL_OFF: Int = 1

    var logLevel: Int = LOG_LEVEL_DEBUG
    fun d(tag: String = LOG_DEFAULT_TAG, msg: String) {
        if (logLevel >= LOG_LEVEL_DEBUG) {
            Log.i(tag, msg)
        }
    }

    fun i(tag: String = LOG_DEFAULT_TAG, msg: String) {
        if (logLevel >= LOG_LEVEL_INFO) {
            Log.d(tag, msg)
        }
    }
}

