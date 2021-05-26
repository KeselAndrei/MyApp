package com.gmail.keseltms.myapp.homework4

class Worker(name: String, salary: Int) : Employee(name, salary) {
    fun work() {
        println("$name работает.")
    }
}