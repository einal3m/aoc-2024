import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day04Test : DescribeSpec({
    describe("part 1") {
        it("works for examples") {
            val input = listOf(
                "MMMSXXMASM",
                "MSAMXMSMSA",
                "AMXSXMAAMM",
                "MSAMASMSMX",
                "XMASAMXAMM",
                "XXAMMXXAMA",
                "SMSMSASXSS",
                "SAXAMASAAA",
                "MAMMMXMMMM",
                "MXMXAXMASX"
            )
            Day04().part1(input) shouldBe 18
        }

        it("works for real") {
            val input = File("src/test/resources/Day04Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 04 Part One:")
            println(Day04().part1(input))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for examples") {
            val input = listOf(
                "MMMSXXMASM",
                "MSAMXMSMSA",
                "AMXSXMAAMM",
                "MSAMASMSMX",
                "XMASAMXAMM",
                "XXAMMXXAMA",
                "SMSMSASXSS",
                "SAXAMASAAA",
                "MAMMMXMMMM",
                "MXMXAXMASX"
            )

            Day04().part2(input) shouldBe 9
        }

        it("works for real") {
            val input = File("src/test/resources/Day04Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 04 Part Two:")
            println(Day04().part2(input))
            println("--------------------------")
        }
    }
})
