import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day08Test : DescribeSpec({
    val exampleInput = listOf(
        "............",
        "........0...",
        ".....0......",
        ".......0....",
        "....0.......",
        "......A.....",
        "............",
        "............",
        "........A...",
        ".........A..",
        "............",
        "............",
    )

    describe("part 1") {
        it("works for examples") {
            Day08().part1(exampleInput) shouldBe 14
        }

        it("works for real") {
            val input = File("src/test/resources/Day08Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 08 Part One:")
            println(Day08().part1(input))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for examples") {
            Day08().part2(exampleInput) shouldBe 34
        }

        it("works for real") {
            val input = File("src/test/resources/Day08Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 08 Part Two:")
            println(Day08().part2(input))
            println("--------------------------")
        }
    }
})
