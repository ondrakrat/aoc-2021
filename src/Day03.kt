import kotlin.math.pow

fun main() {
    val testInput = readInput("input/day3/test")
    val input = readInput("input/day3/data")

    part1(input)
//    part2(input)
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
}
