package me.xns.kotlin.demo.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import me.xns.kotlin.demo.util.Logger

/**
 * Created by xiongningsheng on 2017/6/5.
 */

open class BaseActivity : AppCompatActivity() {
    val tag = "BaseActivity"
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Logger.d(tag, "onCreate")
    }
}