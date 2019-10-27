package test.kotlin.hackerrank

import java.util.*
import kotlin.collections.HashMap

class SockMerchant: IHackerrankInput {
    init {
        println("SockMerchant")
    }

    // Complete the sockMerchant function below.
    private fun sockMerchant(n: Int, ar: Array<Int>): Int {
        val colors: HashMap<Int, Int> = HashMap();
        for (i in ar) {
            var color = colors.getOrDefault(i, 0)
            colors.put(i, ++color)
        }

        var pairs = 0
        for (color in colors.keys) {
            pairs += (colors[color] ?: 0) / 2
        }

        return pairs;
    }

    override fun main(args: String) {
        println("SockMerchant start ${args}")

        val scan = Scanner(args)

        val n = scan.nextLine().trim().toInt()

        val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

        val result = sockMerchant(n, ar)

        println(result)
    }
}