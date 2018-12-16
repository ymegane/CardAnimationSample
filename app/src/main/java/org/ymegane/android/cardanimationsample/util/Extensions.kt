package org.ymegane.android.cardanimationsample.util

import android.app.Activity

inline fun <reified T> Activity.lazyWithExtras(key: String): Lazy<T> {
    return lazy { intent.extras!!.get(key) as T }
}