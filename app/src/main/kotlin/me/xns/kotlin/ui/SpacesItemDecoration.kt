package me.xns.kotlin.ui

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View


/**
 * Created by xiongningsheng on 2017/6/9.
 */
class SpacesItemDecoration(private val space: Int, val orientation: Orientation) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {
        outRect.right = space
        outRect.bottom = space
        // Add top margin only for the first item to avoid double space between items
        if (orientation == Orientation.vertical) {
            outRect.left = space
            if (parent.getChildPosition(view) == 0)
                outRect.top = space
        } else {
            outRect.top = space
            if (parent.getChildPosition(view) == 0)
                outRect.left = space
        }
    }

    enum class Orientation {
        horizontal, vertical
    }
}
