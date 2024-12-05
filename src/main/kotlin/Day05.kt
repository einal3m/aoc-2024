class Day05 {
    fun part1(input: List<String>): Int {
        val (rules, orders) = parseInput(input)
        val comparator = createComparator(rules)

        return orders.sumOf { order ->
            val orderedOrder = order.sortedWith(comparator)
            if (orderedOrder == order) {
                order[(order.size-1)/2]
            } else {
                0
            }
        }
    }

    fun part2(input: List<String>): Int {
        val (rules, orders) = parseInput(input)
        val comparator = createComparator(rules)

        return orders.sumOf { order ->
            val orderedOrder = order.sortedWith(comparator)
            if (orderedOrder != order) {
                orderedOrder[(orderedOrder.size-1)/2]
            } else {
                0
            }
        }
    }

    fun parseInput(input: List<String>): Pair<List<Pair<Int,Int>>, List<List<Int>>> {
        val rules = mutableListOf<Pair<Int, Int>>()
        val orders = mutableListOf<List<Int>>()
        var firstSection = true
        input.forEach { line ->
            if (line == "") {
                firstSection = false
            } else if (firstSection) {
                rules.add(Pair(line.substringBefore("|").toInt(), line.substringAfter("|").toInt()))
            } else {
                orders.add(line.split(",").map{it.toInt()})
            }
        }

        return Pair(rules, orders)
    }

    private fun createComparator(rules: List<Pair<Int,Int>>): Comparator<Int> {
        return Comparator { o1: Int, o2: Int ->
            val inOrderRule = rules.find { rule -> rule.first == o1 && rule.second == o2 }
            if (inOrderRule != null) {
                return@Comparator -1
            }

            val unOrderedRule = rules.find { rule -> rule.second == o1 && rule.first == o2 }
            if (unOrderedRule != null) {
                return@Comparator 1
            }

            return@Comparator 0
        }
    }
}
