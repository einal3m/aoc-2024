import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day13Test : DescribeSpec({
    val exampleInput = listOf(
        "Button A: X+94, Y+34",
        "Button B: X+22, Y+67",
        "Prize: X=8400, Y=5400",
        "",
        "Button A: X+26, Y+66",
        "Button B: X+67, Y+21",
        "Prize: X=12748, Y=12176",
        "",
        "Button A: X+17, Y+86",
        "Button B: X+84, Y+37",
        "Prize: X=7870, Y=6450",
        "",
        "Button A: X+69, Y+23",
        "Button B: X+27, Y+71",
        "Prize: X=18641, Y=10279"
    )

    describe("part 1") {
        it("works for examples") {
            Day13().part1(exampleInput, 0) shouldBe 480
        }

        it("works for real") {
            val input = File("src/test/resources/Day13Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 13 Part One:")
            println(Day13().part1(input, 0))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for real") {
            val input = File("src/test/resources/Day13Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 13 Part Two:")
            println(Day13().part1(input, 10000000000000))
            println("--------------------------")
        }
    }
})
