import kotlin.math.pow

class Day17 {
    fun part1(input: List<String>): String {
        val computer = parseInput(input)
        computer.run()
        return computer.output.joinToString(",")
    }

    fun part2(input: List<String>): Long {
        val computer = parseInput(input)
        return findEntries(computer.instructions.size - 1, 0, computer.instructions)
    }

    fun findEntries(i: Int, startingA: Long, instructions: List<Int>): Long {
        for (A in (startingA * 8) until (startingA * 8 + 8)) {
            val computer = IntCodeComputer(A, 0, 0, instructions)
            computer.run()

            if (computer.output == instructions.takeLast(instructions.size - i)) {
                if (i == 0) return A
                val tryNext = findEntries(i - 1, A, instructions)
                if (tryNext != 0L) return tryNext
            }
        }

        return 0L
    }

    fun parseInput(input: List<String>): IntCodeComputer {
        val a = input[0].substringAfter("A: ").toLong()
        val b = input[1].substringAfter("B: ").toLong()
        val c = input[2].substringAfter("C: ").toLong()
        val instructions = input[4].substringAfter(": ").split(",").map { it.toInt() }

        return IntCodeComputer(a, b, c, instructions)
    }
}

class IntCodeComputer(var registerA: Long, var registerB: Long, var registerC: Long, val instructions: List<Int>) {
    var output = mutableListOf<Int>()
    var i = 0

    fun run(): List<Int> {
        while (processNextInstruction()) {
            // do nothing
        }
        return output
    }

    fun processNextInstruction(): Boolean {
        if (i >= instructions.size) return false

        val code = instructions[i]
        val literalOperand = instructions[i + 1].toLong()

        val comboOperand = when (literalOperand) {
            4L -> registerA
            5L -> registerB
            6L -> registerC
            else -> literalOperand
        }

        if (2.0.pow(comboOperand.toDouble()).toInt() == 0 && (code == 0 || code == 6 || code == 7)) {
            return false
        }

        i += 2
        when (code) {
            // adv -> A = A / 2**comboOperand.
            0 -> registerA = (registerA / 2.0.pow(comboOperand.toDouble()).toInt())

            // bxl -> B = B XOR literalOperand
            1 -> registerB = registerB.xor(literalOperand)

            // bst -> B = comboOperand % 8
            2 -> registerB = comboOperand % 8

            // jnz -> i = literalOperand
            3 -> {
                if (registerA != 0L) {
                    i = literalOperand.toInt()
                }
            }

            // bxc -> B = B XOR C
            4 -> registerB = registerB.xor(registerC)

            // out -> comboOperand % 8
            5 -> output.add((comboOperand % 8).toInt())

            // bdv -> B = A / 2**comboOperand.
            6 -> registerB = (registerA / 2.0.pow(comboOperand.toDouble()).toInt())

            // cdv -> C = A / 2**comboOperand.
            7 -> registerC = (registerA / 2.0.pow(comboOperand.toDouble()).toInt())
        }

        return true
    }
}
