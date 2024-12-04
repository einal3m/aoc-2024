import kotlin.math.abs

class Day03 {
    fun part1(input: List<String>): Int {
        return input.sumOf{ line ->
            val match = Regex("(mul\\(\\d+,\\d+\\))").findAll(line)

            match.sumOf { m ->
                val numbers = m.value.substringAfter("(").substringBefore(")").split(",")
                numbers[0].toInt() * numbers[1].toInt()
            }
        }
    }

    fun part2(input: List<String>): Int {
        var on = true

        return input.sumOf{ line ->
            val match = Regex("(mul\\(\\d+,\\d+\\))|(don't\\(\\))|(do\\(\\))").findAll(line)

            var count = 0
            match.forEach { m ->
                when (m.value) {
                    "don't()" -> on = false
                    "do()" -> on = true
                    else -> {
                        if (on) {
                            val numbers = m.value.substringAfter("(").substringBefore(")").split(",")
                            count += numbers[0].toInt() * numbers[1].toInt()
                        }
                    }
                }
            }
            count
        }
    }
}
