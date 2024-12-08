class Day08 {
    fun part1(input: List<String>): Int {
        val grid = parseInput(input)
        val heightRange = 0..(input.size - 1)
        val widthRange = 0..(input[0].length - 1)
        val antenodes = Grid<Char>()

        grid.grid.forEach { (point, antenna) ->
            grid.grid.forEach { (point2, antenna2) ->
                if (point != point2 && antenna == antenna2) {
                    val vector = point - point2

                    val antenode1 = point + vector
                    val antenode2 = point2 - vector

                    if (antenode1.x in widthRange && antenode1.y in heightRange) antenodes.addPoint(antenode1, '#')
                    if (antenode2.x in widthRange && antenode2.y in heightRange) antenodes.addPoint(antenode2, '#')
                }
            }
        }

        return antenodes.grid.size
    }

    fun part2(input: List<String>): Int {
        val grid = parseInput(input)
        val heightRange = 0..(input.size - 1)
        val widthRange = 0..(input[0].length - 1)
        val antenodes = Grid<Char>()

        grid.grid.forEach { (point, antenna) ->
            grid.grid.forEach { (point2, antenna2) ->
                if (point != point2 && antenna == antenna2) {
                    antenodes.addPoint(point, '#')

                    val diff = point - point2
                    var vector1 = point - point2
                    while ((point.x + vector1.x) in widthRange && (point.y + vector1.y) in heightRange) {
                        antenodes.addPoint(Point(point.x + vector1.x, point.y + vector1.y), '#')
                        vector1 += diff
                    }

                    var vector2 = point - point2
                    while ((point2.x - vector2.x) in widthRange && (point2.y - vector2.y) in heightRange) {
                        antenodes.addPoint(Point(point2.x - vector2.x, point2.y - vector2.y), '#')
                        vector2 -= diff
                    }
                }
            }
        }

        return antenodes.grid.size
    }

    fun parseInput(input: List<String>): Grid<Char> {
        val grid = Grid<Char>()
        input.withIndex().forEach { (y, row) ->
            row.withIndex().forEach { (x, value) ->
                if (value != '.') {
                    grid.addPoint(Point(x, y), value)
                }
            }
        }
        return grid
    }
}
