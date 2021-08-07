package com.hk.kotlindsl

import android.content.Context
import android.content.Intent

fun Toast(lambda: ToastN.() -> (Unit)) {
    val toastN = ToastN()
    toastN.lambda()
    if(toastN.duration == ToastN.Duration.LONG)
        android.widget.Toast.makeText(toastN.context, toastN.message, android.widget.Toast.LENGTH_LONG).show()
    if(toastN.duration ==  ToastN.Duration.SHORT)
        android.widget.Toast.makeText(toastN.context, toastN.message, android.widget.Toast.LENGTH_SHORT).show()
}

fun intent(lambda: IntentN.() -> Unit): Intent {
    val intentN = IntentN()
    intentN.lambda()
    val intent = Intent(intentN.from, intentN.to)
        for(i in intentN.extras.listOfPuts) {
            intent.putExtra(i.key, i.value)
        }
    return intent
}

fun Context.startActivity(lamdba: () -> Intent) {
    startActivity(lamdba())
}

fun put(lambda: Put.() -> Unit) : Put {
    val put = Put()
    put.lambda()
    return put
}

fun extras(lambda: Extras.() -> Unit): Extras {
    val extras = Extras()
    extras.lambda()
    println("extras - ${extras.listOfPuts}")
    return extras
}