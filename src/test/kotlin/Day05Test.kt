import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day05Test : DescribeSpec({
    describe("part 1") {
        it("works for examples") {
            val input = listOf(
                "47|53",
                "97|13",
                "97|61",
                "97|47",
                "75|29",
                "61|13",
                "75|53",
                "29|13",
                "97|29",
                "53|29",
                "61|53",
                "97|53",
                "61|29",
                "47|13",
                "75|47",
                "97|75",
                "47|61",
                "75|61",
                "47|29",
                "75|13",
                "53|13",
                "",
                "75,47,61,53,29",
                "97,61,53,29,13",
                "75,29,13",
                "75,97,47,61,53",
                "61,13,29",
                "97,13,75,29,47",
            )
            Day05().part1(input) shouldBe 143
        }

        it("works for real") {
            val input = File("src/test/resources/Day05Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 05 Part One:")
            println(Day05().part1(input))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for examples") {
            val input = listOf(
                "47|53",
                "97|13",
                "97|61",
                "97|47",
                "75|29",
                "61|13",
                "75|53",
                "29|13",
                "97|29",
                "53|29",
                "61|53",
                "97|53",
                "61|29",
                "47|13",
                "75|47",
                "97|75",
                "47|61",
                "75|61",
                "47|29",
                "75|13",
                "53|13",
                "",
                "75,47,61,53,29",
                "97,61,53,29,13",
                "75,29,13",
                "75,97,47,61,53",
                "61,13,29",
                "97,13,75,29,47",
            )

            Day05().part2(input) shouldBe 123
        }

        it("works for real") {
            val input = File("src/test/resources/Day05Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 05 Part Two:")
            println(Day05().part2(input))
            println("--------------------------")
        }
    }
})
