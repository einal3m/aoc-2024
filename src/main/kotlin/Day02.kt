import kotlin.math.abs

class Day02 {
    fun part1(input: List<String>): Int {
        val grid = parseInput(input)
        return grid.sumOf { report -> if (isSafe(report)) 1.toInt() else 0 }
    }

    fun part2(input: List<String>): Int {
        val grid = parseInput(input)

        var count = 0
        grid.forEach { report ->
            if (isSafe(report)) {
                count++
            } else {
                for (i in 0..(report.size - 1)) {
                    if (isSafe(report.toMutableList().also { it.removeAt(i) })) {
                        count++
                        break
                    }
                }
            }
        }
        return count
    }

    private fun parseInput(input: List<String>): List<List<Int>> {
        return input.map { line -> line.split(" ").map { it.toInt() } }
    }

    private fun isSafe(report: List<Int>): Boolean {
        val diffs = report.zipWithNext().map { (l, r) -> l - r }
        return (diffs.all { it < 0 } || diffs.all { it > 0 }) && diffs.all { abs(it) in 1..3 }
    }
}
