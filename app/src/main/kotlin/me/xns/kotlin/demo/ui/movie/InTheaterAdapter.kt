package me.xns.kotlin.demo.ui.movie

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import me.xns.kotlin.demo.R
import me.xns.kotlin.demo.model.bean.Subject

/**
 * Created by xiongningsheng on 2017/6/6.
 */
class InTheaterAdapter(val context: Context) : Adapter<InTheaterHolder>() {


    var data: List<Subject> = mutableListOf()
        get() = field
        set(value) {
            val mutableList = field as MutableList
            mutableList.clear()
            mutableList.addAll(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): InTheaterHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_movie_in_theater, null)
        return InTheaterHolder(context, view)
    }

    override fun onBindViewHolder(holder: InTheaterHolder?, position: Int) {
        holder?.bindData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

class InTheaterHolder(val context: Context, itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var iconBig: ImageView? = null
    var tvTitle: TextView? = null
    var ratingBar: RatingBar? = null

    init {
        itemView?.let {
            iconBig = itemView.findViewById(R.id.iv_icon_big) as ImageView
            tvTitle = itemView.findViewById(R.id.tv_title) as TextView
            ratingBar = itemView.findViewById(R.id.rating_bar) as RatingBar
        }
    }

    fun bindData(subject: Subject) {
        tvTitle?.text = subject.title
        Glide.with(context).load(subject.images.large).into(iconBig)
        ratingBar?.max = subject.rating.max.toInt()
        ratingBar?.rating = subject.rating.average.toFloat()
    }

}