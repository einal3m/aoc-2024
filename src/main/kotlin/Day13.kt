class Day13 {
    fun part1(input: List<String>, offset: Long): Long {
        val data = parseInput(input)

        return data.sumOf { game ->
            var (aX, aY, bX, bY, pX, pY) = game
            pY += offset
            pX += offset

            val a = (bY * pX - bX * pY) / (bY * aX - bX * aY)
            val b = (aX * pY - aY * pX) / (aX * bY - aY * bX)

            if ((aX * a + bX * b == pX) && (aY * a + bY * b == pY)) {
                (3 * a) + b
            } else {
                0
            }
        }
    }

    private fun parseInput(input: List<String>): List<List<Long>> {
        return input.chunked(4).map { chunk ->
            listOf(extractPoint(chunk[0]), extractPoint(chunk[1]), extractPrize(chunk[2])).flatten()
        }
    }

    private fun extractPoint(input: String): List<Long> {
        val x = input.substringAfter("X").substringBefore(",").toLong()
        val y = input.substringAfter("Y").toLong()
        return listOf(x, y)
    }

    private fun extractPrize(input: String): List<Long> {
        val x = input.substringAfter("X=").substringBefore(",").toLong()
        val y = input.substringAfter("Y=").toLong()
        return listOf(x, y)
    }
}

private operator fun <E> List<E>.component6(): E {
    return get(5)
}
