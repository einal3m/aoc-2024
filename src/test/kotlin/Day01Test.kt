import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day01Test : DescribeSpec({
    describe("part 1") {
        it("works for examples") {
            val input = listOf(
                "3   4",
                "4   3",
                "2   5",
                "1   3",
                "3   9",
                "3   3",
            )
            Day01().part1(input) shouldBe 11
        }

        it("works for real") {
            val input = File("src/test/resources/Day01Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 01 Part One:")
            println(Day01().part1(input))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for examples") {
            val input = listOf(
                "3   4",
                "4   3",
                "2   5",
                "1   3",
                "3   9",
                "3   3",
            )

            Day01().part2(input) shouldBe 31
        }

        it("works for real") {
            val input = File("src/test/resources/Day01Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 01 Part Two:")
            println(Day01().part2(input))
            println("--------------------------")
        }
    }
})
