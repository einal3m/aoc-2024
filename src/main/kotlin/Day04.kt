class Day04 {
    private val allDirs = arrayOf(
        Point(0, 1),
        Point(0, -1),
        Point(-1, 0),
        Point(1, 0),
        Point(-1, -1),
        Point(-1, 1),
        Point(1, 1),
        Point(1, -1),
    )

    fun part1(input: List<String>): Int {
        val grid = parseInput(input)
        var count = 0

        grid.grid.forEach { (point, value) ->
            if (value == 'X') {
                allDirs.forEach { (xDir, yDir) ->
                    if (checkInDirection(grid, point.x, xDir, point.y, yDir)) {
                        count++
                    }
                }
            }
        }
        return count
    }

    private val masDirs = allDirs.takeLast(4)

    fun part2(input: List<String>): Int {
        val grid = parseInput(input)
        var count = 0
        grid.grid.forEach { (point, char) ->
            if (char == 'A') {
                val xNeighbours = "${
                    grid.valueAt(point.x + masDirs[0].x, point.y + masDirs[0].y)
                }${
                    grid.valueAt(point.x + masDirs[1].x, point.y + masDirs[1].y)
                }${
                    grid.valueAt(point.x + masDirs[2].x, point.y + masDirs[2].y)
                }${
                    grid.valueAt(point.x + masDirs[3].x, point.y + masDirs[3].y)
                }"

                if (xNeighbours == "MMSS" || xNeighbours == "MSSM" || xNeighbours == "SSMM" || xNeighbours == "SMMS") {
                    count++
                }
            }
        }
        return count
    }

    private fun parseInput(input: List<String>): Grid<Char> {
        val grid = Grid<Char>()
        input.withIndex().forEach { (y, row) ->
            row.withIndex().forEach { (x, value) ->
                grid.addPoint(Point(x, y), value)
            }
        }
        return grid
    }

    private fun checkInDirection(grid: Grid<Char>, x: Int, xDir: Int, y: Int, yDir: Int): Boolean {
        return (grid.valueAt(x + xDir, y + yDir) == 'M') &&
                (grid.valueAt(x + 2 * xDir, y + 2 * yDir) == 'A') &&
                (grid.valueAt(x + 3 * xDir, y + 3 * yDir) == 'S')
    }
}
