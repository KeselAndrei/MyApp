package com.gmail.keseltms.myapp.homework10

import kotlin.random.Random

object FactoryCandy {

    private const val BRAND_SNICKERS = "Snickers"
    private const val BRAND_MARS = "Mars"
    private const val BRAND_TWIX = "Twix"
    private const val SIZE_CANDY = 300

    fun candyMaking(): MutableList<Candy> {
        val listCandy: MutableList<Candy> = mutableListOf()
        for (i in 0..SIZE_CANDY) {
            when (i) {
                in 0..99 -> {
                    listCandy.add(
                        Candy(
                            BRAND_MARS,
                            Random.nextLong(10000000, 99999999)
                        )
                    )

                }
                in 100..199 -> {
                    listCandy.add(
                        Candy(
                            BRAND_SNICKERS,
                            Random.nextLong(10000000, 99999999)
                        )
                    )
                }
                in 200..300 -> {
                    listCandy.add(
                        Candy(
                            BRAND_TWIX,
                            Random.nextLong(10000000, 99999999)
                        )
                    )
                }
            }
        }
        return listCandy
    }
}