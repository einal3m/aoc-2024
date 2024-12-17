import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day17Test : DescribeSpec({
    val exampleInput1 = listOf(
        "Register A: 729",
        "Register B: 0",
        "Register C: 0",
        "",
        "Program: 0,1,5,4,3,0",
    )

    val exampleInput2 = listOf(
        "Register A: 2024",
        "Register B: 0",
        "Register C: 0",
        "",
        "Program: 0,3,5,4,3,0"
    )

    describe("part 1") {
        it("processes instructions correctly") {
            // If register C contains 9, the program 2,6 would set register B to 1.
            var computer = IntCodeComputer(0, 0, 9, listOf(2, 6))
            computer.processNextInstruction()
            computer.registerB shouldBe 1
            computer.i shouldBe 2

            // If register A contains 10, the program 5,0,5,1,5,4 would output 0,1,2.
            computer = IntCodeComputer(10, 0, 0, listOf(5, 0, 5, 1, 5, 4))
            computer.run()
            computer.output shouldBe listOf(0, 1, 2)

            // If register A contains 2024, the program 0,1,5,4,3,0 would output 4,2,5,6,7,7,7,7,3,1,0 and leave 0 in register A.
            computer = IntCodeComputer(2024, 0, 0, listOf(0, 1, 5, 4, 3, 0))
            computer.run()
            computer.output shouldBe listOf(4, 2, 5, 6, 7, 7, 7, 7, 3, 1, 0)
            computer.registerA shouldBe 0

            // If register B contains 29, the program 1,7 would set register B to 26.
            computer = IntCodeComputer(0, 29, 0, listOf(1, 7))
            computer.processNextInstruction()
            computer.registerB shouldBe 26

            // If register B contains 2024 and register C contains 43690, the program 4,0 would set register B to 44354.
            computer = IntCodeComputer(0, 2024, 43690, listOf(4, 0))
            computer.processNextInstruction()
            computer.registerB shouldBe 44354
        }

        it("works for examples") {
            Day17().part1(exampleInput1) shouldBe "4,6,3,5,6,3,5,2,1,0"
        }

        it("works for real") {
            val input = File("src/test/resources/Day17Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 17 Part One:")
            println(Day17().part1(input))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for examples") {
            Day17().part2(exampleInput2) shouldBe 117440
        }

        it("works for real") {
            val input = File("src/test/resources/Day17Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 17 Part Two:")
            println(Day17().part2(input))
            println("--------------------------")
        }
    }
})
