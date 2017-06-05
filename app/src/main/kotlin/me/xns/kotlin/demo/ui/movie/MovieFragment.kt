package me.xns.kotlin.demo.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import me.xns.kotlin.demo.R
import me.xns.kotlin.demo.model.ApiManager
import me.xns.kotlin.demo.model.bean.TheaterInfo
import me.xns.kotlin.demo.ui.BaseFragment
import me.xns.kotlin.demo.util.Logger

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
                .subscribe(object : Observer<TheaterInfo> {
                    override fun onComplete() {
                    }

                    override fun onNext(t: TheaterInfo?) {
                        Logger.d(msg = "TheatorObserver::onNext:::" + t.toString())
                    }

                    override fun onError(e: Throwable?) {
                        Logger.d(msg = e.toString())
                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                })
    }

}


