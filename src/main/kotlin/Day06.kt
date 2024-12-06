class Day06 {
    fun part1(input: List<String>): Int {
        val (startingPos, grid) = parseInput(input)

        addGuardsPath(startingPos, Direction.NORTH, grid)

        return grid.grid.values.count { it in Direction.ALL_CODES }
    }

    fun part2(input: List<String>): Int {
        val (startingPos, grid) = parseInput(input)
        addGuardsPath(startingPos, Direction.NORTH, grid)
        val widthRange = grid.widthRange()
        val heightRange = grid.heightRange()

        var count = 0
        for (y in heightRange) {
            for (x in widthRange) {
                // skip the check if the position is not on the original guards path
                if (grid.valueAt(x, y) == '#' || Point(x, y) == startingPos || grid.valueAt(x, y) == null) {
                    continue
                }

                val (_, newGrid) = parseInput(input)
                var pos = startingPos
                var dir = Direction.NORTH

                // add in the extra obstacle
                newGrid.addPoint(Point(x, y), '#')

                while (true) {
                    // exit if we're not still in the grid
                    if (pos.x !in widthRange || pos.y !in heightRange) {
                        break
                    }

                    // if we've been here before in the same direction, count++ and break
                    if (newGrid.valueAt(pos.x, pos.y) == dir.code()) {
                        count++
                        break
                    }

                    // otherwise add the current pos and move on
                    newGrid.addPoint(pos, dir.code())

                    // if we've hit a block, then find a new direction
                    while (newGrid.valueAt(pos, dir) == '#') {
                        dir = Direction.turnRight(dir)
                    }

                    // move
                    pos += dir
                }
            }
        }
        return count
    }

    private fun parseInput(input: List<String>): Pair<Point, Grid<Char>> {
        var currentPos = Point(0, 0)
        val grid = Grid<Char>()
        input.withIndex().forEach { (y, row) ->
            row.withIndex().forEach { (x, value) ->
                if (value == '#') {
                    grid.addPoint(Point(x, y), value)
                } else if (value == '^') {
                    currentPos = Point(x, y)
                }
            }
        }
        return Pair(currentPos, grid)
    }

    private fun addGuardsPath(
        startingPos: Point,
        startingDir: Point,
        grid: Grid<Char>
    ) {
        val widthRange = grid.widthRange()
        val heightRange = grid.heightRange()
        var pos = startingPos
        var dir = startingDir

        while (true) {
            // if we're out of the grid, return
            if (pos.x !in widthRange || pos.y !in heightRange) {
                return
            }

            // add this position into the grid
            grid.addPoint(pos, dir.code())

            // change direction if we're about to hit a barrier
            if (grid.valueAt(pos.x + dir.x, pos.y + dir.y) == '#') {
                dir = Direction.turnRight(dir)
            }

            // move
            pos = Point(pos.x + dir.x, pos.y + dir.y)
        }
    }
}
