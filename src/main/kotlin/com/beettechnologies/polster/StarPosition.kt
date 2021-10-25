package com.beettechnologies.polster

// Allow mutability from properties
data class StarPosition(var x: Int, var y: Int, val vX: Int, val vY: Int) {
    fun move(forward: Boolean = true) {
        when (forward) {
            true -> {
                x += vX
                y += vY
            }
            else -> {
                x -= vX
                y -= vY
            }
        }
    }
}
