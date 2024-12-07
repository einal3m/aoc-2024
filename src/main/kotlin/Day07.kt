class Day07 {
    fun part1(input: List<String>): Long {
        val calibrations = parseInput(input)

        return calibrations.sumOf { (testValue, operands) ->
            if (testOperand(testValue, 0, operands.toMutableList(), false)) testValue else 0
        }
    }

    fun part2(input: List<String>): Long {
        val calibrations = parseInput(input)

        return calibrations.sumOf { (testValue, operands) ->
            if (testOperand(testValue, 0, operands.toMutableList(), true)) testValue else 0
        }
    }

    private fun testOperand(target: Long, currentValue: Long, operands: MutableList<Long>, concat: Boolean): Boolean {
        if (currentValue > target) return false
        if (operands.isEmpty()) return (target == currentValue)

        val newOperands = operands.toMutableList()
        val nextOperand = newOperands.removeFirst()

        return testOperand(target, currentValue + nextOperand, newOperands, concat) ||
                testOperand(
                    target,
                    (if (currentValue == 0.toLong()) 1.toLong() else currentValue) * nextOperand,
                    newOperands,
                    concat
                ) ||
                (concat && testOperand(target, "$currentValue$nextOperand".toLong(), newOperands, concat))
    }

    private fun parseInput(input: List<String>): List<Pair<Long, List<Long>>> {
        return input.map { line ->
            val testValue = line.substringBefore(":").toLong()
            val operands = line.substringAfter(": ").split(" ").map { it.toLong() }
            Pair(testValue, operands)
        }
    }
}
