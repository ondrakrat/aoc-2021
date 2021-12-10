import kotlin.math.pow

fun main() {
    val testInput = readInput("input/day3/test")
    val input = readInput("input/day3/data")

//    part1(input)
    part2(input)
}

private fun part1(input: List<String>) {
    val zeroFrequency = IntArray(input[0].length)
    val oneFrequency = IntArray(input[0].length)
    for (s in input) {
        s.toCharArray()
            .map { it == '1' }
            .forEachIndexed { index, bit ->
                if (bit) {
                    ++oneFrequency[index]
                } else {
                    ++zeroFrequency[index]
                }
            }
    }
    val gamma = zeroFrequency
        .zip(oneFrequency)
        .map { if (it.first < it.second) 1 else 0 }
        .reduce { acc, b -> acc shl 1 or b }
    val bitMask = 2.toDouble().pow(input[0].length).toInt() - 1
    val epsilon = gamma xor bitMask
    println(gamma * epsilon)
}

private fun part2(input: List<String>) {
    val oxygen = getRating(input, true)
    val co2 = getRating(input, false)
    println(Integer.parseInt(oxygen, 2) * Integer.parseInt(co2, 2))
}

private fun getRating(input: List<String>, most: Boolean): String {
    var zeroFrequency = 0
    var oneFrequency = 0
    var candidates = listOf(*input.toTypedArray())
    var currentPos = 0
    while (candidates.size > 1) {
        oneFrequency = onesOnPosition(candidates, currentPos)
        zeroFrequency = candidates.size - oneFrequency
        val filteredDigit = if (most) {
            if (oneFrequency >= zeroFrequency) '1' else '0'
        } else {
            if (zeroFrequency <= oneFrequency) '0' else '1'
        }
        candidates = candidates.filter { it.toCharArray()[currentPos] == filteredDigit }
        ++currentPos
    }
    return candidates[0]
}

private fun onesOnPosition(input: List<String>, position: Int) = input.sumOf { it.toCharArray()[position].digitToInt() }
