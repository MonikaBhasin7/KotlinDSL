package com.hk.kotlindsl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val person = person {
            name = "Krishna"
            age = 1000000000
        }
        println("person - ${person.name}")
    }
}

fun person(lambda : Person.()-> Unit) : Person {
    val person = Person()
    person.lambda()
    return person
}