package com.hk.kotlindsl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hk.kotlindsl.DSLUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val person = person {
            name = "Krishna"
            age = 1000000000
        }
        println("person - ${person.name}")

        Toast.makeText(this, "abd", Toast.LENGTH_SHORT).show()
        /*
        * Toast {
        *   context = this,
        *   msg = "abd"
        *   duration = Toast.LENGTH_SHORT
        * }
        * */
        DSLUtils.Toast {
            context = this@MainActivity
            message = "Hey all"
            duration = ToastN.Duration.SHORT
        }


        Intent(this, MainActivity::class.java)
        
        DSLUtils.intent {
            from = this@MainActivity
            to = MainActivity::class.java
        }
    }
}

fun person(lambda : Person.()-> Unit) : Person {
    val person = Person()
    person.lambda()
    person.apply {  }
    return person
}