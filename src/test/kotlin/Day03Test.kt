import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day03Test : DescribeSpec({
    describe("part 1") {
        it("works for examples") {
            val input = listOf(
                "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
            )
            Day03().part1(input) shouldBe 161
        }

        it("works for real") {
            val input = File("src/test/resources/Day03Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 03 Part One:")
            println(Day03().part1(input))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for examples") {
            val input = listOf(
                "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
            )

            Day03().part2(input) shouldBe 48
        }

        // not
        // 85711693
        it("works for real") {
            val input = File("src/test/resources/Day03Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 03 Part Two:")
            println(Day03().part2(input))
            println("--------------------------")
        }
    }
})
