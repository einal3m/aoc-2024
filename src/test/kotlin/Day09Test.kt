import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day09Test : DescribeSpec({
    val exampleInput = "2333133121414131402"
    describe("part 1") {
        it("works for examples") {
            Day09().part1(exampleInput) shouldBe 1928
        }

        it("works for real") {
            val input = File("src/test/resources/Day09Input.txt").readText()
            println("--------------------------")
            println("Answer to Day 09 Part One:")
            println(Day09().part1(input))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for examples") {
            Day09().part2(exampleInput) shouldBe 2858
        }

        it("works for real") {
            val input = File("src/test/resources/Day09Input.txt").readText()
            println("--------------------------")
            println("Answer to Day 09 Part Two:")
            println(Day09().part2(input))
            println("--------------------------")
        }
    }
})
