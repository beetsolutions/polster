package com.beettechnologies.polster

fun main(args: Array<String>) {
    val information = SkyMessage(args[1 + args.indexOf("-d")])
    println(information.computeMessage().first)
}