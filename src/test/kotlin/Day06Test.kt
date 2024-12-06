import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day06Test : DescribeSpec({
    val exampleInput = listOf(
        "....#.....",
        ".........#",
        "..........",
        "..#.......",
        ".......#..",
        "..........",
        ".#..^.....",
        "........#.",
        "#.........",
        "......#..."
    )

    describe("part 1") {
        it("works for examples") {
            Day06().part1(exampleInput) shouldBe 41
        }

        it("works for real") {
            val input = File("src/test/resources/Day06Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 06 Part One:")
            println(Day06().part1(input))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for examples") {
            Day06().part2(exampleInput) shouldBe 6
        }

        it("works for real") {
            val input = File("src/test/resources/Day06Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 06 Part Two:")
            println(Day06().part2(input))
            println("--------------------------")
        }
    }
})
