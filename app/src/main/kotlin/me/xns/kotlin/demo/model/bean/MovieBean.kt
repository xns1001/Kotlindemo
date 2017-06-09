package me.xns.kotlin.demo.model.bean

/**
 * Created by xiongningsheng on 2017/6/9.
 */

data class Rating(val max: Double, val average: Double,
                  val stars: String, val min: Double)

data class Cast(val alt: String, val avatars: Avatars, val name: String, val id: String)

data class Director(val alt: String, val avatars: Avatars)

data class Avatars(val small: String, val large: String, val medium: String)

data class Subject(val rating: Rating, val genres: List<String>, val title: String,
                   val casts: List<Cast>, val collect_count: Long,
                   val original_title: String, val subtype: String,
                   val directors: List<Director>, val year: String, val images: Avatars,
                   val pubdates: List<String>, //如果条目类型是电影则为上映日期，如果是电视剧则为首播日期
                   val alt: String, val id: String
)

data class MovieInfo(val code: Int,
                     val msg: String,
                     val request: String,
                     val title: String,
                     val total: Int,
                     val start: Int,
                     val count: Int,
                     val subjects: List<Subject>
)