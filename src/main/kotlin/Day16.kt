import java.util.PriorityQueue

class Day16 {
    fun part1(input: List<String>): Int {
        val (grid, start, end) = parseInput(input)
        val seen = processPath(start, grid)
        return seen.filter { (k, v) -> k.first == end }.values.min()
    }

    private fun processPath(
        start: Point,
        grid: Grid<Char>
    ): HashMap<Pair<Point, Point>, Int> {
        val seen = HashMap<Pair<Point, Point>, Int>()

        val queue = PriorityQueue<Triple<Point, Point, Int>>(compareBy { it.third })
        queue.add(Triple(start, Direction.EAST, 0))

        while (queue.isNotEmpty()) {
            val currentState = queue.poll()
            val currentPos = currentState.first
            val currentDir = currentState.second
            val currentCost = currentState.third

            val neighbours = listOf(
                Triple(currentPos + currentDir, currentDir, currentCost + 1),
                Triple(currentPos, Direction.turnLeft(currentDir), currentCost + 1000),
                Triple(currentPos, Direction.turnRight(currentDir), currentCost + 1000),
            )

            for (neighbour in neighbours) {
                val cost = seen[Pair(neighbour.first, neighbour.second)]
                if (grid.valueAt(neighbour.first) == '#') continue
                if (cost == null) {
                    seen[Pair(neighbour.first, neighbour.second)] = neighbour.third
                    queue.add(neighbour)
                } else if (neighbour.third < cost) {
                    seen[Pair(neighbour.first, neighbour.second)] = neighbour.third
                }
            }
        }
        return seen
    }

    fun part2(input: List<String>): Int {
        val (grid, start, end) = parseInput(input)

        val seen = processPath(start, grid)
        val lastStep = seen.filter { (k, v) -> k.first == end }.entries.minBy { e -> e.value }

        val queue = PriorityQueue<Triple<Point, Point, Int>>(compareBy { it.third })
        queue.add(Triple(lastStep.key.first, lastStep.key.second, lastStep.value))

        val onPath = mutableListOf(Pair(lastStep.key.first, lastStep.key.second))

        while (queue.isNotEmpty()) {
            val c = queue.poll()

            val currentPos = c.first
            val currentDir = c.second
            val currentCost = c.third

            val neighbours = listOf(
                Triple(currentPos - currentDir, currentDir, currentCost - 1),
                Triple(currentPos, Direction.turnLeft(currentDir), currentCost - 1000),
                Triple(currentPos, Direction.turnRight(currentDir), currentCost - 1000),
            )

            for (neighbour in neighbours) {
                if (neighbour.third == seen[Pair(neighbour.first, neighbour.second)]) {
                    onPath.add(Pair(neighbour.first, neighbour.second))
                    queue.add(neighbour)
                }
            }
        }

        onPath.add(Pair(start, Direction.EAST))

        return onPath.map { it.first }.distinct().size
    }

    private fun parseInput(input: List<String>): Triple<Grid<Char>, Point, Point> {
        var start = Point(0, 0)
        var end = Point(0, 0)
        val grid = Grid<Char>()

        input.withIndex().forEach { (y, row) ->
            row.withIndex().forEach { (x, char) ->
                when (char) {
                    '#' -> grid.addPoint(Point(x, y), char)
                    'S' -> start = Point(x, y)
                    'E' -> end = Point(x, y)
                }
            }
        }

        return Triple(grid, start, end)
    }
}
