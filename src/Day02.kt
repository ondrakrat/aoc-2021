fun main() {
    val testInput = readInput("input/day2/test")
    val input = readInput("input/day2/data")

    part1(input)
//    part2(input)
}

private fun part1(input: List<String>) {
    var depth = 0
    var horizontal = 0
    for (s in input) {
        val args = s.trim().split(" ")
        if (args.size != 2) throw Exception("Unexpected parameter size: ${args.size} for line $s")
        val command = args[0].trim()
        val numVal = args[1].trim().toInt()
        when (command) {
            "forward" -> horizontal += numVal
            "up" -> depth -= numVal
            "down" -> depth += numVal
            else -> throw Exception("Invalid command: $command")
        }
    }
    println("Depth: $depth, horizontal: $horizontal, result: ${depth * horizontal}")
}

private fun part2(input: List<String>) {
    TODO("Not implemented")
}
