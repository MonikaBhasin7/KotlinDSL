package com.hk.kotlindsl

import kotlin.properties.Delegates

class Person {
    lateinit var name: String
    var age by Delegates.notNull<Int>()
}