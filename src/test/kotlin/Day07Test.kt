import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day07Test : DescribeSpec({
    val exampleInput = listOf(
        "190: 10 19",
        "3267: 81 40 27",
        "83: 17 5",
        "156: 15 6",
        "7290: 6 8 6 15",
        "161011: 16 10 13",
        "192: 17 8 14",
        "21037: 9 7 18 13",
        "292: 11 6 16 20",
    )

    describe("part 1") {
        it("works for examples") {
            Day07().part1(exampleInput) shouldBe 3749
        }

        it("works for real") {
            val input = File("src/test/resources/Day07Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 07 Part One:")
            println(Day07().part1(input))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for examples") {
            Day07().part2(exampleInput) shouldBe 11387
        }

        it("works for real") {
            val input = File("src/test/resources/Day07Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 07 Part Two:")
            println(Day07().part2(input))
            println("--------------------------")
        }
    }
})
