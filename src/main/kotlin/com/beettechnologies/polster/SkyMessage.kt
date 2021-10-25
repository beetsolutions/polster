package com.beettechnologies.polster

import kotlin.math.absoluteValue

val IntRange.span: Long get() = (this.last.toLong() - this.first.toLong()).absoluteValue

data class SkyMessage(val positions: List<StarPosition>) {

    private fun area(): Long = xRange().span * yRange().span

    fun computeMessage(): Pair<String, Int> {
        var timeToComputeMessage = -1
        var lastArea = Long.MAX_VALUE

        var currentArea = area()

        while (currentArea < lastArea) {
            move(true)
            lastArea = currentArea
            currentArea = area()
            timeToComputeMessage++
        }

        move(false)
        return Pair(toString(), timeToComputeMessage)
    }

    private fun move(forward: Boolean = true) {
        positions.forEach { it.move(forward) }
    }

    private fun xRange(): IntRange {
        return IntRange(positions.minByOrNull { it.x }?.x ?: 0, positions.maxByOrNull { it.x }?.x ?: 0)
    }

    private fun yRange(): IntRange {
        return IntRange(positions.minByOrNull { it.y }?.y ?: 0, positions.maxByOrNull { it.y }?.y ?: 0)
    }

    override fun toString(): String {
        val positionsSet = positions.map { Pair(it.x, it.y) }.toSet()
        return yRange().joinToString(separator = "\n") { y ->
            xRange().map { x ->
                if (Pair(x, y) in positionsSet) '#' else '.'
            }.joinToString(separator = "")
        }
    }
}