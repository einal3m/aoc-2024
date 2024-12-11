class Day10 {
    fun part1(input: List<String>): Int {
        val grid = parseInput(input)

        var count = 0
        grid.grid.filter { it.value == 0 }.forEach { (point, _) ->
            val newPaths = findPaths(point, grid, 0, mutableListOf())
            count += newPaths.map { it.last() }.distinct().size
        }
        return count
    }

    fun part2(input: List<String>): Int {
        val grid = parseInput(input)

        var count = 0
        grid.grid.filter { it.value == 0 }.forEach { (point, _) ->
            val newPaths = findPaths(point, grid, 0, mutableListOf())
            count += newPaths.size
        }
        return count
    }

    private fun findPaths(
        pos: Point,
        grid: Grid<Int>,
        currentValue: Int,
        currentPath: MutableList<Point>
    ): MutableList<List<Point>> {
        val newPath = currentPath.toMutableList()
        newPath.add(pos)

        if (currentValue == 9) {
            return mutableListOf(newPath)
        }

        val newPaths = mutableListOf<List<Point>>()
        Direction.ALL_DIRS.forEach { dir ->
            if (grid.valueAt(pos, dir) == currentValue + 1) {
                newPaths.addAll(findPaths(pos + dir, grid, currentValue + 1, newPath))
            }
        }
        return newPaths
    }

    private fun parseInput(input: List<String>): Grid<Int> {
        val grid = Grid<Int>()
        input.withIndex().forEach { (y, row) ->
            row.withIndex().forEach { (x, char) ->
                grid.addPoint(Point(x, y), "$char".toInt())
            }
        }
        return grid
    }
}
