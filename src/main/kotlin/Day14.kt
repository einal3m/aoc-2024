class Day14 {
    fun part1(input: List<String>, width: Int, height: Int): Int {
        var grid = parseInput(input)

        (1..100).forEach { tick ->
            val newGrid = Grid<MutableList<Point>>()

            grid.grid.forEach { (pos, velocities) ->
                velocities.forEach { v ->
                    val newPos = Point(wrap(pos.x + v.x, width), wrap(pos.y + v.y, height))
                    if (newGrid.valueAt(newPos) != null) {
                        var currentValue = newGrid.valueAt(newPos)!!
                        currentValue.add(v)
                    } else {
                        newGrid.addPoint(newPos, mutableListOf(v))
                    }
                }
            }
            grid = newGrid

// check for christmas tree
//
//            var checkThisOne = false
//            if (newGrid.grid.values.count { it.size > 1 } == 0) {
//                println("")
//                println("")
//                newGrid.print(0..(width-1), 0..(height-1))
//                print("hit enter ($tick): ")
//                readlnOrNull()
//            }
        }

        var q1 = 0
        var q2 = 0
        var q3 = 0
        var q4 = 0
        grid.grid.forEach { (k, v) ->
            if ((k.x < (width - 1) / 2) && (k.y < (height - 1) / 2)) {
                q1 += v.size
            } else if ((k.x > (width - 1) / 2) && (k.y < (height - 1) / 2)) {
                q2 += v.size
            } else if ((k.x < (width - 1) / 2) && (k.y > (height - 1) / 2)) {
                q3 += v.size
            } else if ((k.x > (width - 1) / 2) && (k.y > (height - 1) / 2)) {
                q4 += v.size
            }
        }

        return q1 * q2 * q3 * q4
    }

    private fun parseInput(input: List<String>): Grid<MutableList<Point>> {
        val grid = Grid<MutableList<Point>>()
        input.forEach { line ->
            val pX = line.substringAfter("p=").substringBefore(",").toInt()
            val pY = line.substringAfter(",").substringBefore(" ").toInt()
            val vX = line.substringAfter("v=").substringBefore(",").toInt()
            val vY = line.substringAfterLast(",").toInt()

            if (grid.valueAt(pX, pY) != null) {
                var currentValue = grid.valueAt(pX, pY)!!
                currentValue.add(Point(vX, vY))
            } else {
                grid.addPoint(Point(pX, pY), mutableListOf(Point(vX, vY)))
            }
        }
        return grid
    }

    private fun wrap(value: Int, max: Int): Int {
        if (value >= max) {
            return value % max
        }

        if (value < 0) {
            return max + value
        }

        return value
    }
}
