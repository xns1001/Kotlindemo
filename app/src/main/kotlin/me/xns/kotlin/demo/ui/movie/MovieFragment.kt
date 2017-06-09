package me.xns.kotlin.demo.ui.movie

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.HORIZONTAL
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main_movie.*
import me.xns.kotlin.demo.R
import me.xns.kotlin.demo.model.ApiManager
import me.xns.kotlin.demo.model.bean.MovieInfo
import me.xns.kotlin.demo.model.bean.Subject
import me.xns.kotlin.demo.ui.BaseFragment
import me.xns.kotlin.demo.util.Logger
import me.xns.kotlin.ui.SpacesItemDecoration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by xiongningsheng on 2017/6/5.
 */
class MovieFragment : BaseFragment() {
    companion object {
        val tag = "movie"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main_movie, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val observable = ApiManager.movieApi.getInTheaters()
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<MovieInfo> {
                    override fun onComplete() {
                    }

                    override fun onNext(t: MovieInfo?) {
                        Logger.d(msg = "TheatorObserver::onNext:::" + t.toString())
                        if (t == null) {
                            showInTheaters(null)
                            return
                        }
                        if (t.subjects.isEmpty()) {
                            showInTheaters(null)
                            return
                        }
                        showInTheaters(t.subjects)
                    }

                    override fun onError(e: Throwable?) {
                        Logger.d(msg = e.toString())
                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                })
        val call = ApiManager.movieApi.getCommingSoon()
        call.enqueue(object : Callback<MovieInfo> {
            override fun onFailure(call: Call<MovieInfo>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<MovieInfo>?, response: Response<MovieInfo>?) {
                response?.let {
                    val body = response.body()
                    body?.let {
                        Logger.d(msg = "coming-soon response=$body")
                    }
                }
            }


        })
    }

    fun showInTheaters(list: List<Subject>?) {
        Logger.d(msg = "list=$list")
        if (list == null) {
            tv_in_theater_top.visibility = View.GONE
            recycler_in_theater.visibility = View.GONE
            return
        }
        tv_in_theater_top.visibility = View.VISIBLE
        recycler_in_theater.visibility = View.VISIBLE
        val adapter = InTheaterAdapter(activity!!)
        list?.let { adapter.data = list }
        recycler_in_theater.layoutManager = LinearLayoutManager(activity, HORIZONTAL, false)
        recycler_in_theater.addItemDecoration(SpacesItemDecoration(20, SpacesItemDecoration.Orientation.horizontal))
        recycler_in_theater.adapter = adapter

    }

}


