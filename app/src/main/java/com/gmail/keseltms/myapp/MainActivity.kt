package com.gmail.keseltms.myapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gmail.keseltms.myapp.homework6.Homework6Activity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      HOMEWORK2
//        FactoryCarSingleton.printCars()
//      HOMEWORK3
//        val dogBobbi = Dog("Bobbi", 22.2)
//        println(
//            "${dogBobbi.name} пробежал за ${
//                String.format("%.4f", dogBobbi.getTime())
//            } часа"
//        )
//
//        val elephantTom = Elephant("Tom", 11.1)
//        println(
//            "${elephantTom.name} пробежал за ${
//                String.format("%.4f", elephantTom.getTime())
//            } часа"
//        )

//      HOMEWORK4
//        val collectionEmployee = mutableListOf<Employee>()
//        collectionEmployee.addAll(FactoryEmployee.listBoss)
//        collectionEmployee.addAll(FactoryEmployee.listFirstBossManagers)
//        collectionEmployee.addAll(FactoryEmployee.listSecondBossManagers)
//        collectionEmployee.addAll(FactoryEmployee.firstListFirstManagerWorkers)
//        collectionEmployee.addAll(FactoryEmployee.secondListFirstManagerWorkers)
//        collectionEmployee.addAll(FactoryEmployee.firstListSecondManagerWorkers)
//        collectionEmployee.addAll(FactoryEmployee.secondListSecondManagerWorkers)
//
//
//        collectionEmployee.forEach {
//            println(
//                "${it.name} зарабатывает ${it.salary}$, у него ${
//                    (it as? Boss)?.listManager?.size ?: (it as? Manager)
//                        ?.listWorker?.size ?: "нет"
//                } подчиненных."
//            )
//            (it as? Worker)?.work()
//        }
//
//        //      TASK *
//
//        val listEmployee: MutableList<Employee> = mutableListOf<Employee>().apply {
//            addAll(FactoryEmployee.listBoss)
//            addAll(FactoryEmployee.listFirstBossManagers)
//            addAll(FactoryEmployee.listSecondBossManagers)
//            addAll(FactoryEmployee.firstListFirstManagerWorkers)
//            addAll(FactoryEmployee.secondListFirstManagerWorkers)
//            addAll(FactoryEmployee.firstListSecondManagerWorkers)
//            addAll(FactoryEmployee.secondListSecondManagerWorkers)
//        }
//
//        fun Employee.printInfoBoss(list: MutableList<Manager>): String {
//            val listString: MutableList<String> = mutableListOf()
//            list.forEach {
//                listString.add(
//                    "Менеджер ${it.name} зарабатывает ${it.salary}$, у него ${
//                        (it as? Manager)?.listWorker?.size
//                    } подчиненных."
//                )
//            }
//            return listString.toString()
//        }
//
//        fun Employee.printInfoManager(list: MutableList<Worker>): String {
//            val listString: MutableList<String> = mutableListOf()
//            list.forEach {
//                listString.add(
//                    "Рабочий ${it.name} зарабатывает ${it.salary}$, " +
//                            "у него нет подчиненных"
//                )
//            }
//            return listString.toString()
//        }
//
//        listEmployee.forEach {
//            println(
//                "${it.name} зарабатывает ${it.salary}$, у него ${
//                    (it as? Boss)?.listManager?.size ?: (it as? Manager)
//                        ?.listWorker?.size ?: "нет"
//                } подчиненных: ${
//                    (it as? Boss)?.printInfoBoss(it.listManager)
//                        ?: (it as? Manager)?.printInfoManager(it.listWorker) ?: "\b\b."
//                }"
//            )
//            (it as? Worker)?.work()
//        }
//        HOMEWORK6
        val textView: TextView = findViewById(R.id.text2)
        textView.setOnClickListener {
            val intent = Intent(this, Homework6Activity::class.java)
            startActivity(intent)

        }
    }
}
