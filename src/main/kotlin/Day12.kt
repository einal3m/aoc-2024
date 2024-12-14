class Day12 {
    fun part1(input: List<String>): Int {
        val farm = parseInput(input)
        val processed = mutableSetOf<Point>()

        var result = 0
        farm.grid.forEach { point, value ->
            if (processed.contains(point)) return@forEach

            val connected = mutableSetOf<Point>()
            val q = ArrayDeque<Point>()
            var perimeter = 0
            var area = 0

            q.add(point)
            while (q.isNotEmpty()) {
                val p = q.removeFirst()
                processed.add(p)

                if (connected.contains(p)) continue
                connected.add(p)
                area++

                Direction.ALL_DIRS.forEach { dir ->
                    if (value == farm.valueAt(p, dir) && !q.contains(p + dir) && !processed.contains(p + dir)) {
                        q.add(p + dir)
                    } else if (value != farm.valueAt(p, dir)) {
                        perimeter++
                    }
                }
            }
            result += area * perimeter
        }

        return result
    }

    fun part2(input: List<String>): Int {
        val farm = parseInput(input)
        val processed = mutableSetOf<Point>()

        var result = 0
        farm.grid.forEach { point, value ->
            if (processed.contains(point)) return@forEach

            val connected = mutableSetOf<Point>()
            val q = ArrayDeque<Point>()
            var perimeter = 0
            var area = 0

            q.add(point)
            while (q.isNotEmpty()) {
                val p = q.removeFirst()
                processed.add(p)

                if (connected.contains(p)) continue
                connected.add(p)
                area++

                Direction.ALL_DIRS.forEach { dir ->
                    if (value == farm.valueAt(p, dir) && !q.contains(p + dir) && !processed.contains(p + dir)) {
                        q.add(p + dir)
                    }
                }

                perimeter += listOf(
                    Direction.NORTH,
                    Direction.EAST,
                    Direction.SOUTH,
                    Direction.WEST,
                    Direction.NORTH
                ).zipWithNext().count { (dirA, dirB) ->
                    if (farm.valueAt(p, dirA) != value && farm.valueAt(p, dirB) != value) {
                        true
                    } else {
                        farm.valueAt(p, dirA) == value && farm.valueAt(p, dirB) == value && farm.valueAt(
                            p,
                            dirA + dirB
                        ) != value
                    }
                }
            }
            result += area * perimeter
        }

        return result
    }

    private fun parseInput(input: List<String>): Grid<Char> {
        val grid = Grid<Char>()
        input.withIndex().forEach { (y, row) ->
            row.withIndex().forEach { (x, char) ->
                grid.addPoint(Point(x, y), char)
            }
        }
        return grid
    }
}
