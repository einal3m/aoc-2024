import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day10Test : DescribeSpec({
    val exampleInput = listOf(
        "89010123",
        "78121874",
        "87430965",
        "96549874",
        "45678903",
        "32019012",
        "01329801",
        "10456732",
    )
    describe("part 1") {
        it("works for examples") {
            Day10().part1(exampleInput) shouldBe 36
        }

        it("works for real") {
            val input = File("src/test/resources/Day10Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 10 Part One:")
            println(Day10().part1(input))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for examples") {
            Day10().part2(exampleInput) shouldBe 81
        }

        it("works for real") {
            val input = File("src/test/resources/Day10Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 10 Part Two:")
            println(Day10().part2(input))
            println("--------------------------")
        }
    }
})
