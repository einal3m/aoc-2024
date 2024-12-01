import kotlin.math.abs

class Day01 {
    fun part1(input: List<String>): Int {
        val first = firstColumn(input)
        val second = secondColumn(input)

        return (first zip second).sumOf { (l, r) -> abs(l - r) }
    }

    fun part2(input: List<String>): Int {
        val first = firstColumn(input)
        val second = secondColumn(input)

        val frequencies = second.groupingBy { it }.eachCount()

        return first.sumOf { num -> num * (frequencies[num] ?: 0) }
    }

    private fun firstColumn(input: List<String>): List<Int> {
        return input.map { line -> line.substringBefore(" ").toInt() }.sorted()
    }

    private fun secondColumn(input: List<String>): List<Int> {
        return input.map { line -> line.substringAfterLast(" ").toInt() }.sorted()
    }
}
