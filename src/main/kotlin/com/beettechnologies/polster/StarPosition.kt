package com.beettechnologies.polster

data class StarPosition(
    val x: Int,
    val y: Int,
    val vX: Int,
    val vY: Int
) {
    fun move()  = copy(x = x + vX, y = y + vY)
}