package com.hk.kotlindsl

import android.content.Context
import android.widget.Toast

object DSLUtils {

    fun Toast(lambda: ToastN.() -> (Unit)) {
        val toastN = ToastN()
        toastN.lambda()
        if(toastN.duration == ToastN.Duration.LONG)
            Toast.makeText(toastN.context, toastN.message, Toast.LENGTH_LONG).show()
        if(toastN.duration == ToastN.Duration.SHORT)
            Toast.makeText(toastN.context, toastN.message, Toast.LENGTH_SHORT).show()
    }
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