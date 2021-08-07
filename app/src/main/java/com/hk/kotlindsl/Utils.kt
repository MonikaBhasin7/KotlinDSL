package com.hk.kotlindsl

import android.content.Context
import android.content.Intent

fun Toast(lambda: ToastN.() -> (Unit)) {
    val toastN = ToastN()
    toastN.lambda()
    if(toastN.duration == ToastN.Duration.LONG)
        android.widget.Toast.makeText(toastN.context, toastN.message, android.widget.Toast.LENGTH_LONG).show()
    if(toastN.duration == ToastN.Duration.SHORT)
        android.widget.Toast.makeText(toastN.context, toastN.message, android.widget.Toast.LENGTH_SHORT).show()
}

fun intent(lambda: IntentN.() -> Unit): Intent {
    val intentN = IntentN()
    intentN.lambda()
    return Intent(intentN.from, intentN.to)
}

fun Context.startActivity(lamdba: () -> (Intent)) {
    startActivity(lamdba())
}