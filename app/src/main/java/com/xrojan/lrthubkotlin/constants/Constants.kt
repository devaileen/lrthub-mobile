package com.xrojan.lrthubkotlin.constants

import com.xrojan.lrthubkotlin.ui.feed.FeedDetailDialogFragment

/**
 * Created by Joshua de Guzman on 10/07/2018.
 */

class HTTP {
    companion object {
        val OK = 200
        val CREATED = 201
        val MULTIPLE_CHOICES = 300
        val MOVED_PERMANENTLY = 301
        val FOUND = 302
        val NOT_MODIFIED = 304
        val TEMPORARY_REDIRECT = 307
        val BAD_REQUEST = 400
        val UNAUTHORIZED = 401
        val FORBIDDEN = 403
        val NOT_FOUND = 404
        val GONE = 410
        val INTERNAL_SERVICE_ERROR = 500
        val NOT_IMPLEMENTED = 501
        val SERVICE_UNAVAILABLE = 503
        val PERMISSION_DENIED = 550
    }
}

class TAG {
    companion object {
        val FEED_DETAIL = FeedDetailDialogFragment::class.java.simpleName
    }
}

class EVENT_TRACKER {
    companion object {
        val ADS = "Advertisement"
        val FEED = "Feeds/News"
        val FEED_CATEGORY = "Feed Category"
        val FEED_FEATURED = "Featured Feed"
        val FEED_NON_FEATURED = "Non Featured Feed"
        val LOGIN = "Login"
    }
}

enum class ASK_MESSAGE_MODE {
    USER_SENDER, CHATBOT_SENDER
}