import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day14Test : DescribeSpec({
    val exampleInput = listOf(
        "p=0,4 v=3,-3",
        "p=6,3 v=-1,-3",
        "p=10,3 v=-1,2",
        "p=2,0 v=2,-1",
        "p=0,0 v=1,3",
        "p=3,0 v=-2,-2",
        "p=7,6 v=-1,-3",
        "p=3,0 v=-1,-2",
        "p=9,3 v=2,3",
        "p=7,3 v=-1,2",
        "p=2,4 v=2,-3",
        "p=9,5 v=-3,-3",
    )

    describe("part 1") {
        it("works for examples") {
            Day14().part1(exampleInput, 11, 7) shouldBe 12
        }

        it("works for real") {
            val input = File("src/test/resources/Day14Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 14 Part One:")
            println(Day14().part1(input, 101, 103))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for real") {
            val input = File("src/test/resources/Day14Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 14 Part Two:")
            println(Day14().part1(input, 101, 103))
            println("--------------------------")
        }
    }
})
