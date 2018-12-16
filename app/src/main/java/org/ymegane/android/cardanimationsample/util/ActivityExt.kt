package org.ymegane.android.cardanimationsample.util

import android.app.Activity
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.core.util.Pair as AndroidPair

fun Activity.makeSceneWithSystemBar(vararg sharedElements: AndroidPair<View, String>): ActivityOptionsCompat {
    val decorView = window.decorView
    val pairs = sharedElements.toMutableList()

    decorView.findViewById<View>(android.R.id.statusBarBackground)?.let {
        pairs.add(AndroidPair(it, TRANSITION_NAME_STATUS_BAR))
    }
    decorView.findViewById<View>(android.R.id.navigationBarBackground)?.let {
        pairs.add(AndroidPair(it, TRANSITION_NAME_NAVIGATION_BAR))
    }

    return ActivityOptionsCompat.makeSceneTransitionAnimation(this, *pairs.toTypedArray())
}

fun Activity.setSystemBarTransition() {
    val decorView = window.decorView

    decorView.findViewById<View>(android.R.id.statusBarBackground)?.let {
        ViewCompat.setTransitionName(it, TRANSITION_NAME_STATUS_BAR)
    }
    decorView.findViewById<View>(android.R.id.navigationBarBackground)?.let {
        ViewCompat.setTransitionName(it, TRANSITION_NAME_NAVIGATION_BAR)
    }
}

const val TRANSITION_NAME_STATUS_BAR = "statusBar"
const val TRANSITION_NAME_NAVIGATION_BAR = "navigationBar"
