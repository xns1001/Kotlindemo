package me.xns.kotlin.demo.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import me.xns.kotlin.demo.R
import me.xns.kotlin.demo.ui.book.BookFragment
import me.xns.kotlin.demo.ui.movie.MovieFragment
import me.xns.kotlin.demo.ui.music.MusicFragment

class MainActivity : BaseActivity() {
    var currentFragment: Fragment? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_movie -> {
                instantiate(MovieFragment.tag)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_book -> {
                instantiate(BookFragment.tag)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_music -> {
                instantiate(MusicFragment.tag)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instantiate(MovieFragment.tag)
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun instantiate(tag: String) {
        var fragment: Fragment? = supportFragmentManager.findFragmentByTag(tag)
        if (fragment == null) {
            fragment = if (tag == MovieFragment.tag) {
                MovieFragment()
            } else if (tag == BookFragment.tag) {
                BookFragment()
            } else {
                MusicFragment()
            }
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.fl_container, fragment, tag)
            if (currentFragment != null) {
                transaction.hide(currentFragment)
            }
            transaction.commitNow()
        } else {
            if (currentFragment == fragment) return
            val transaction = supportFragmentManager.beginTransaction()
            transaction.show(fragment)
                    .hide(currentFragment)
                    .commitNow()

        }
        currentFragment = fragment

    }

}
