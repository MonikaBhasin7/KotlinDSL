package com.hk.kotlindsl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

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
        Toast {
            context = this@MainActivity
            message = "Hey all"
            duration = ToastN.Duration.SHORT
        }


        //Intent(this, MainActivity::class.java)

        startActivity {
            intent {
                from = this@MainActivity
                to = NewActivity::class.java
                extras {
                    put {
                        key = "android"
                        value = "kotlin"
                    }
                    put {
                        key = "ios"
                        value = "swift"
                    }
                }
            }
        }
    }
}

fun person(lambda : Person.()-> Unit) : Person {
    val person = Person()
    person.lambda()
    person.apply {  }
    return person
}