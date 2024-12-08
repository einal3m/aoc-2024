data class Point(val x: Int, val y: Int) {
    override fun toString(): String {
        return "(${x},${y})"
    }

    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun minus(other: Point): Point {
        return Point(x - other.x, y - other.y)
    }

    fun code(): Char {
        return when (this) {
            Direction.NORTH -> 'N'
            Direction.SOUTH -> 'S'
            Direction.EAST -> 'E'
            Direction.WEST -> 'W'
            else -> ' '
        }
    }
}

object Direction {
    val NORTH = Point(0, -1)
    val SOUTH = Point(0, 1)
    val EAST = Point(1, 0)
    val WEST = Point(-1, 0)
    val ALL_CODES = listOf(NORTH, SOUTH, EAST, WEST).map{it.code()}

    fun turnRight(direction: Point): Point {
        return when (direction) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            else -> NORTH
        }
    }
}
