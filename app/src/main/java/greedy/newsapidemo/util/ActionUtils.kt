package greedy.newsapidemo.util

import android.util.Log
import greedy.newsapidemo.BuildConfig

/**
 * Utility functions related actions inside app. Extensions functions that prevents duplicated
 * code blocks.
 *
 * @author greedy
 * @since  13 Jun 2021
 */

fun Any.log(message: String) {
    if (BuildConfig.DEBUG) Log.d(this.javaClass.name, "log: $message")
}