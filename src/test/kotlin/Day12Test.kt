import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day12Test : DescribeSpec({
    val exampleInput1 = listOf(
        "AAAA",
        "BBCD",
        "BBCC",
        "EEEC",
    )

    val exampleInput2 = listOf(
        "OOOOO",
        "OXOXO",
        "OOOOO",
        "OXOXO",
        "OOOOO",
    )

    val exampleInput3 = listOf(
        "RRRRIICCFF",
        "RRRRIICCCF",
        "VVRRRCCFFF",
        "VVRCCCJFFF",
        "VVVVCJJCFE",
        "VVIVCCJJEE",
        "VVIIICJJEE",
        "MIIIIIJJEE",
        "MIIISIJEEE",
        "MMMISSJEEE",
    )

    val exampleInput4 = listOf(
        "EEEEE",
        "EXXXX",
        "EEEEE",
        "EXXXX",
        "EEEEE",
    )

    val exampleInput5 = listOf(
        "AAAAAA",
        "AAABBA",
        "AAABBA",
        "ABBAAA",
        "ABBAAA",
        "AAAAAA",
    )

    describe("part 1") {
        it("works for examples") {
            Day12().part1(exampleInput1) shouldBe 140
            Day12().part1(exampleInput2) shouldBe 772
            Day12().part1(exampleInput3) shouldBe 1930
        }

        it("works for real") {
            val input = File("src/test/resources/Day12Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 12 Part One:")
            println(Day12().part1(input))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for examples") {
            Day12().part2(exampleInput1) shouldBe 80
            Day12().part2(exampleInput2) shouldBe 436
            Day12().part2(exampleInput3) shouldBe 1206
            Day12().part2(exampleInput4) shouldBe 236
            Day12().part2(exampleInput5) shouldBe 368
        }

        it("works for real") {
            val input = File("src/test/resources/Day12Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 12 Part Two:")
            println(Day12().part2(input))
            println("--------------------------")
        }
    }
})
