package me.xns.kotlin.demo.model

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by xiongningsheng on 2017/6/5.
 */
object ApiManager {
    val okClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
                .build()
    }


    val movieApi: MovieApi by lazy {
        Retrofit.Builder()
                .client(okClient)
                .baseUrl("https://api.douban.com/v2/movie/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(MovieApi::class.java)
    }
}