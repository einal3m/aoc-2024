class Grid<T> {
    var grid = mutableMapOf<Point, T>()

    fun addPoint(point: Point, value: T) {
        grid[point] = value
    }

    fun valueAt(p: Point): T? {
        return grid[p]
    }

    fun valueAt(x: Int, y: Int): T? {
        return grid[Point(x, y)]
    }

    fun valueAt(pos: Point, direction: Point): T? {
        return grid[pos + direction]
    }

    fun widthRange(): IntRange {
        val minX = grid.minByOrNull { it.key.x }?.key?.x ?: 999
        val maxX = grid.maxByOrNull { it.key.x }?.key?.x ?: -999

        return (minX..maxX)
    }

    fun heightRange(): IntRange {
        val minY = grid.minByOrNull { it.key.y }?.key?.y ?: 999
        val maxY = grid.maxByOrNull { it.key.y }?.key?.y ?: -999

        return (minY..maxY)
    }

    override fun toString(): String {
        return grid.map { "${it.key}->${it.value}" }.joinToString(", ")
    }

    fun print() {
        for (y in heightRange()) {
            var row = ""
            for (x in widthRange()) {
                val value = grid[Point(x,y)]
                if (value is MutableList<*>) {
                    row += value.size
                } else {
                    row += grid[Point(x, y)] ?: "."
                }
            }
            println(row)
        }
    }

    fun print(widthRange: IntRange, heightRange: IntRange) {
        for (y in heightRange) {
            var row = ""
            for (x in widthRange) {
                val value = grid[Point(x,y)]
                if (value is MutableList<*>) {
                    row += value.size
                } else {
                    row += grid[Point(x, y)] ?: "."
                }
            }
            println(row)
        }
    }
}