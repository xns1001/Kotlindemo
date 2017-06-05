package me.xns.kotlin.demo.model.bean

/**
 * Created by xiongningsheng on 2017/6/5.
 */
data class TheaterInfo(val code: Int,
                       val msg: String,
                       val request: String,
                       val title: String,
                       val total: Int,
                       val start: Int,
                       val count: Int,
                       val subjects: List<Subject>
)

data class Subject(val rating: Rating, val genres: List<String>, val title: String,
                   val casts: List<Cast>, val collect_count: Long,
                   val original_title: String, val subtype: String,
                   val directors: List<Director>, val year: String, val images: Avatars,
                   val alt: String, val id: String
)

data class Rating(val max: Double, val average: Double,
                  val stars: String, val min: Double)

data class Cast(val alt: String, val avatars: Avatars, val name: String, val id: String)

data class Director(val alt: String, val avatars: Avatars)

data class Avatars(val small: String, val large: String, val medium: String)