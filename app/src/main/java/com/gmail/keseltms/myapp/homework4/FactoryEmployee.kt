package com.gmail.keseltms.myapp.homework4

object FactoryEmployee {
    val firstListFirstManagerWorkers: MutableList<Worker> = mutableListOf(
        Worker("Вася", 600),
        Worker("Ваня", 650),
        Worker("Валера", 700)
    )

    val secondListFirstManagerWorkers: MutableList<Worker> = mutableListOf(
        Worker("Семен", 650),
        Worker("Сеня", 700),
        Worker("Саня", 750)
    )

    val firstListSecondManagerWorkers: MutableList<Worker> = mutableListOf(
        Worker("Вася", 650),
        Worker("Сеня", 700),
        Worker("Валера", 750)
    )

    val secondListSecondManagerWorkers: MutableList<Worker> = mutableListOf(
        Worker("Валера", 650),
        Worker("Сеня", 700),
        Worker("Семен", 750)
    )

    val listFirstBossManagers: MutableList<Manager> = mutableListOf(
        Manager("Петр", 1500, firstListFirstManagerWorkers),
        Manager("Павел", 1600, secondListFirstManagerWorkers)
    )

    val listSecondBossManagers: MutableList<Manager> = mutableListOf(
        Manager("Игорь", 1700, firstListSecondManagerWorkers),
        Manager("Слава", 1800, secondListSecondManagerWorkers)
    )

    val listBoss: MutableList<Boss> = mutableListOf(
        Boss("Николай", 5000, listFirstBossManagers),
        Boss("Аркадий", 6000, listSecondBossManagers)
    )
}