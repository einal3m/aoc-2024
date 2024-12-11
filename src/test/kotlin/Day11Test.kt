import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day11Test : DescribeSpec({
    val exampleInput = "125 17"

    describe("part 1") {
        it("works for examples") {
            Day11().part1(exampleInput, 25) shouldBe 55312
        }

        it("works for real") {
            val input = File("src/test/resources/Day11Input.txt").readText()
            println("--------------------------")
            println("Answer to Day 11 Part One:")
            println(Day11().part1(input, 25))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for real") {
            val input = File("src/test/resources/Day11Input.txt").readText()
            println("--------------------------")
            println("Answer to Day 11 Part Two:")
            println(Day11().part1(input, 75))
            println("--------------------------")
        }
    }
})
