package com.hk.kotlindsl

import android.content.Context
import android.content.Intent
import android.widget.Toast

object DSLUtils {



}

class IntentN {
    lateinit var from: Context
    lateinit var to : Class<*>
}

class ToastN {
    lateinit var context: Context
    lateinit var message: CharSequence
    lateinit var duration: Duration

    sealed class Duration {
        object LONG : Duration()
        object SHORT: Duration()
    }
}