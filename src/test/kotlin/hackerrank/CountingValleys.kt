package test.kotlin.hackerrank

import java.util.*

class CountingValleys : IHackerrankInput {

    override fun main(args: String) {
        println("CountingValleys start ${args}")

        val scan = Scanner(args)

        val n = scan.nextLine().trim().toInt()

        val s = scan.nextLine()

        val result = countingValleys(n, s)

        println(result)
    }

    private fun countingValleys(n: Int, s: String?): Any {
        val steps = s ?: ""
        var altitude = 0
        var isValley = false
        var valleysCount = 0
        for (step in steps) {
            isValley = isValley || altitude == 0
            altitude += if (step == 'U') 1 else -1
            if (altitude > 0)
                isValley = false
            if (altitude == 0 && isValley)
                valleysCount += 1
        }

        return valleysCount
    }
}