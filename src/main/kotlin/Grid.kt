class Grid<T> {
    var grid = mutableMapOf<Point, T>()

    fun addPoint(point: Point, value: T) {
        grid[point] = value
    }

    fun valueAt(x: Int, y: Int): T? {
        return grid[Point(x, y)]
    }

    override fun toString(): String {
        return grid.map { "${it.key}->${it.value}" }.joinToString(", ")
    }

    fun print() {
        val minX = grid.minByOrNull { it.key.x }?.key?.x ?: 999
        val maxX = grid.maxByOrNull { it.key.x }?.key?.x ?: -999
        val minY = grid.minByOrNull { it.key.y }?.key?.y ?: 999
        val maxY = grid.maxByOrNull { it.key.y }?.key?.y ?: -999

        for (y: Int in minY..maxY) {
            var row = ""
            for (x in minX..maxX) {
                row += grid[Point(x,y)]
            }
            println(row)
        }
    }
}