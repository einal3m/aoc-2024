import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

import java.io.File

class Day16Test : DescribeSpec({
    val exampleInput1 = listOf(
        "###############",
        "#.......#....E#",
        "#.#.###.#.###.#",
        "#.....#.#...#.#",
        "#.###.#####.#.#",
        "#.#.#.......#.#",
        "#.#.#####.###.#",
        "#...........#.#",
        "###.#.#####.#.#",
        "#...#.....#.#.#",
        "#.#.#.###.#.#.#",
        "#.....#...#.#.#",
        "#.###.#.#.#.#.#",
        "#S..#.....#...#",
        "###############",
    )

    val exampleInput2 = listOf(
        "#################",
        "#...#...#...#..E#",
        "#.#.#.#.#.#.#.#.#",
        "#.#.#.#...#...#.#",
        "#.#.#.#.###.#.#.#",
        "#...#.#.#.....#.#",
        "#.#.#.#.#.#####.#",
        "#.#...#.#.#.....#",
        "#.#.#####.#.###.#",
        "#.#.#.......#...#",
        "#.#.###.#####.###",
        "#.#.#...#.....#.#",
        "#.#.#.#####.###.#",
        "#.#.#.........#.#",
        "#.#.#.#########.#",
        "#S#.............#",
        "#################",
    )

    describe("part 1") {
        it("works for examples") {
            Day16().part1(exampleInput1) shouldBe 7036
            Day16().part1(exampleInput2) shouldBe 11048
        }

        it("works for real") {
            val input = File("src/test/resources/Day16Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 16 Part One:")
            println(Day16().part1(input))
            println("--------------------------")
        }
    }

    describe("part 2") {
        it("works for examples") {
            Day16().part2(exampleInput1) shouldBe 45
            Day16().part2(exampleInput2) shouldBe 64
        }

        it("works for real") {
            val input = File("src/test/resources/Day16Input.txt").readLines()
            println("--------------------------")
            println("Answer to Day 16 Part Two:")
            println(Day16().part2(input))
            println("--------------------------")
        }
    }
})
