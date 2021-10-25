package com.beettechnologies.polster

import java.io.File

object Application {

    object Main {
        @JvmStatic
        fun main(args: Array<String>) {

            val url = Application.javaClass.classLoader.getResource("input.txt")

            url?.let {
                val input = File(it.toURI()).readLines()

                val information = SkyMessage(positions = input.map { position ->
                    position
                        .split(",", "<", ">")
                        .map { value ->
                            value.trim()
                        }.run {
                            StarPosition(this[1].toInt(), this[2].toInt(), this[4].toInt(), this[5].toInt())
                        }
                })

                println(information.computeMessage().first)
            }
        }
    }
}
