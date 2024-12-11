class Day11 {
    fun part1(input: String, iterations: Int): Long {
        var stones = parseInput(input)

        (1..iterations).forEach { i ->
            val newStones = mutableMapOf<String, Long>()

            stones.forEach { (stone, count) ->
                if (stone == "0") {
                    newStones.merge("1", count, Long::plus)
                } else if (stone.length % 2 == 0) {
                    newStones.merge(stone.substring(0, stone.length/2).toLong().toString(), count, Long::plus)
                    newStones.merge(stone.substring(stone.length/2, stone.length).toLong().toString(), count, Long::plus)
                } else {
                    newStones.merge("${stone.toLong() * 2024}", count, Long::plus)
                }
            }
            stones = newStones.toMutableMap()
        }

        return stones.values.sum()
    }

    private fun parseInput(input: String): Map<String, Long> {
        val stoneMap = mutableMapOf<String, Long>()

        input.split(" ").forEach { stone ->
            stoneMap.merge(stone, 1, Long::plus)
        }

        return stoneMap
    }
}
