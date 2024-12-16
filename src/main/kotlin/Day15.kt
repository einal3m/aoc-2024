class Day15 {
    val wall = '#'
    val box = 'O'
    val leftBox = '['
    val rightBox = ']'
    val empty = null
    val robot = '@'

    fun part1(input: List<String>): Int {
        var (grid, robot, directions) = parseInput1(input)

        for (dir in directions) {
            if (grid.valueAt(robot, dir) == wall) continue

            if (grid.valueAt(robot, dir) == empty) {
                robot += dir
                continue
            }

            // find a blank spot along the direction and move them all
            var checkPos = robot + dir
            while (grid.valueAt(checkPos) == box) {
                checkPos += dir
            }

            if (grid.valueAt(checkPos) == empty) {
                grid.addPoint(checkPos, box)
                grid.removePoint(robot + dir)
                robot += dir
            }
        }

        return gps(grid)
    }

    fun part2(input: List<String>): Int {
        var (grid, robot, directions) = parseInput2(input)

        for (dir in directions) {
            val currentValue = grid.valueAt(robot, dir)

            if (currentValue == wall) continue

            if (currentValue == empty) {
                robot += dir
                continue
            }

            // horizontal box checking
            if (dir == Direction.EAST || dir == Direction.WEST) {
                var checkPos = robot + dir

                while (grid.valueAt(checkPos) == rightBox || grid.valueAt(checkPos) == leftBox) {
                    checkPos += dir
                }

                if (grid.valueAt(checkPos) == empty) {
                    if (dir == Direction.WEST) {
                        var left = true
                        for (i in (checkPos.x..(robot + dir + dir).x)) {
                            if (left) {
                                grid.addPoint(Point(i, checkPos.y), leftBox)
                            } else {
                                grid.addPoint(Point(i, checkPos.y), rightBox)
                            }
                            left = !left
                        }
                    } else {
                        var left = true
                        for (i in ((robot + dir + dir).x..checkPos.x)) {
                            if (left) {
                                grid.addPoint(Point(i, checkPos.y), leftBox)
                            } else {
                                grid.addPoint(Point(i, checkPos.y), rightBox)
                            }
                            left = !left
                        }
                    }
                    grid.removePoint(robot + dir)
                    robot += dir
                }

                continue
            }

            // vertical box checking
            if (dir == Direction.SOUTH || dir == Direction.NORTH) {
                val q = ArrayDeque<Point>()
                val currentBox = if (currentValue == leftBox) {
                    robot + dir
                } else {
                    Point(robot.x - 1, (robot + dir).y)
                }
                q.add(currentBox)
                val pushList = mutableListOf(currentBox)
                var foundWall = false

                while (q.isNotEmpty() && !foundWall) {
                    val b = q.removeFirst()
                    val belowLeft = grid.valueAt(b + dir)
                    val belowRight = grid.valueAt(Point(b.x + 1, (b + dir).y))

                    if (belowLeft == wall || belowRight == wall) {
                        // if there's a wall below, we can't push anything
                        foundWall = true
                        continue
                    }

                    if (belowLeft == empty && belowRight == empty) {
                        // nothing below, can be pushed
                        if (!pushList.contains(b)) {
                            pushList.add(b)
                        }
                        continue
                    }

                    if (belowLeft == leftBox) { // there is a whole box directly below
                        q.add(b + dir)
                        pushList.add(b + dir)
                        continue
                    }

                    if (belowRight == leftBox) { // there is a box down and to the right
                        q.add(Point(b.x + 1, (b + dir).y))
                        pushList.add(Point(b.x + 1, (b + dir).y))
                    }
                    if (belowLeft == rightBox) { // there is a box down and to the left
                        q.add(Point(b.x - 1, (b + dir).y))
                        pushList.add(Point(b.x - 1, (b + dir).y))
                    }
                }

                if (!foundWall) {
                    robot += dir

                    pushList.forEach { box ->
                        grid.removePoint(box)
                        grid.removePoint(Point(box.x + 1, box.y))
                    }

                    pushList.forEach { box ->
                        grid.addPoint(box + dir, leftBox)
                        grid.addPoint(Point(box.x + 1, (box + dir).y), rightBox)
                    }
                }
            }
        }

        return gps(grid)
    }

    private fun parseInput1(input: List<String>): Triple<Grid<Char>, Point, List<Point>> {
        val grid = Grid<Char>()
        var robot = Point(0, 0)

        for (y in input.indices) {
            val row = input[y]
            if (row.isEmpty()) {
                break
            }
            row.withIndex().forEach { (x, char) ->
                if (char == '@') robot = Point(x, y)
                else if (char != '.') grid.addPoint(Point(x, y), char)
            }
        }

        return Triple(grid, robot, parseDirections(input.last()))
    }

    private fun parseInput2(input: List<String>): Triple<Grid<Char>, Point, List<Point>> {
        val grid = Grid<Char>()
        var robot = Point(0, 0)

        for (y in input.indices) {
            val row = input[y]
            if (row.isEmpty()) {
                break
            }
            row.withIndex().forEach { (x, char) ->
                if (char == this.robot) robot = Point(2 * x, y)
                else if (char == wall) {
                    grid.addPoint(Point(2 * x, y), wall)
                    grid.addPoint(Point(2 * x + 1, y), wall)
                } else if (char == box) {
                    grid.addPoint(Point(2 * x, y), leftBox)
                    grid.addPoint(Point(2 * x + 1, y), rightBox)
                }
            }
        }

        return Triple(grid, robot, parseDirections(input.last()))
    }

    private fun parseDirections(input: String): List<Point> {
        return input.toCharArray().map { char ->
            when (char) {
                '^' -> Direction.NORTH
                'v' -> Direction.SOUTH
                '>' -> Direction.EAST
                else -> Direction.WEST
            }
        }
    }

    private fun gps(grid: Grid<Char>): Int {
        var result = 0
        grid.grid.forEach { point, value ->
            if (value == box || value == leftBox) {
                result += (100 * point.y) + point.x
            }
        }
        return result
    }
}
