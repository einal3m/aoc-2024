import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day02Test : DescribeSpec({
    describe("part 1") {
        it("works for examples") {
            val input = listOf(
                "7 6 4 2 1",
                "1 2 7 8 9",
                "9 7 6 2 1",
                "1 3 2 4 5",
                "8 6 4 4 1",
                "1 3 6 7 9"
            )
            Day02().part1(input) shouldBe 2
        }

        it("works for real") {
            val input = File("src/test/resources/Day02Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 02 Part One:")
            println(Day02().part1(input))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for examples") {
            val input = listOf(
                "7 6 4 2 1",
                "1 2 7 8 9",
                "9 7 6 2 1",
                "1 3 2 4 5",
                "8 6 4 4 1",
                "1 3 6 7 9"
            )

            Day02().part2(input) shouldBe 4
        }

        it("works for real") {
            val input = File("src/test/resources/Day02Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 02 Part Two:")
            println(Day02().part2(input))
            println("--------------------------")
        }
    }
})
