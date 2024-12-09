class Day09 {
    fun part1(input: String): Long {
        val seq = spreadFiles(input)

        var maxIndex = seq.maxOf { (k, _) -> k }
        while (maxIndex != seq.size - 1) {
            val value = seq[maxIndex]!!
            seq.remove(maxIndex)
            for (k in 0..maxIndex) {
                if (seq[k] == null) {
                    seq[k] = value
                    break
                }
            }
            maxIndex = seq.maxOf { (k, _) -> k }
        }

        return checksum(seq)
    }

    fun part2(input: String): Long {
        val seq = spreadFiles(input)

        var i = seq.maxOf { (k, _) -> k }
        var maxValue = seq[i]
        var indicesInGroup = mutableListOf(i)
        i--
        while (i > 0) {
            val currentValue = seq[i]
            if (currentValue == maxValue && currentValue != null) {
                indicesInGroup.add(i)
            } else {
                if (indicesInGroup.size > 0) {
                    val fileSize = indicesInGroup.size
                    var spaceCount = 0
                    var inSpace = false
                    var spaceStartIndex = 0
                    for (k in 0..(i+1)) {
                        if (seq[k] == null) {
                            if (!inSpace) {
                                inSpace = true
                                spaceStartIndex = k
                            }
                            spaceCount++
                            if (spaceCount == fileSize) {
                                break
                            }
                        } else {
                            inSpace = false
                            spaceStartIndex = 0
                            spaceCount = 0
                        }
                    }

                    if (spaceStartIndex != 0) {
                        for ((l, k) in indicesInGroup.withIndex()) {
                            val value = seq[k]!!
                            seq.remove(k)
                            seq[spaceStartIndex + l] = value
                        }
                    }
                }

                maxValue = seq[i]
                if (maxValue != null) {
                    indicesInGroup = mutableListOf(i)
                } else {
                    indicesInGroup = mutableListOf()
                }
            }
            i--
        }

        return checksum(seq)
    }

    private fun spreadFiles(input: String): MutableMap<Int, Int> {
        val seq = mutableMapOf<Int, Int>()
        var i = 0
        var file = true
        var id = 0
        input.forEach { char ->
            val value = "$char".toInt()
            if (file) {
                for (j in i..<i + value) {
                    seq[j] = id
                }
                id++
                i += value
                file = false
            } else {
                i += value
                file = true
            }
        }

        return seq
    }

    private fun checksum(seq: MutableMap<Int, Int>): Long {
        var count: Long = 0
        seq.forEach { (k, v) ->
            count += k * v
        }
        return count
    }
}
