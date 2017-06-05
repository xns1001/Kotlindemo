package me.xns.kotlin.demo.model

import io.reactivex.Observable
import me.xns.kotlin.demo.model.bean.TheaterInfo
import retrofit2.http.GET

/**
 * Created by xiongningsheng on 2017/6/5.
 */
interface MovieApi {
    @GET("in_theaters")
    fun getInTheaters(): Observable<TheaterInfo>

}