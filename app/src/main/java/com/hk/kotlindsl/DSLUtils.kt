package com.hk.kotlindsl

import android.content.Context
import android.content.Intent
import android.widget.Toast

object DSLUtils {

}

class Put {
    lateinit var key: String
    lateinit var value: String
}

class Extras {
    var listOfPuts: MutableList<Put> = mutableListOf()
    var put: Put
        get() {
            return Put()
        }
        set(value) {
            listOfPuts.add(value)
        }
}

class IntentN {
    lateinit var from: Context
    lateinit var to : Class<*>
    lateinit var extras: Extras
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