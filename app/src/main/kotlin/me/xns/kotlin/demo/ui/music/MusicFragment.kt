package me.xns.kotlin.demo.ui.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.xns.kotlin.demo.R
import me.xns.kotlin.demo.ui.BaseFragment

/**
 * Created by xiongningsheng on 2017/6/5.
 */
class MusicFragment: BaseFragment(){
    companion object{
        val tag="music"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main_music,null)

    }
}