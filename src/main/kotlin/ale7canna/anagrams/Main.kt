package ale7canna.anagrams

import java.io.File

fun main(args: Array<String>) {
    val arg = args.joinToString(" ")
    println("Computing anagrams of $arg")

    val vocabulary = File("dictionary.txt").readLines()
    val permutations = Permutations()
    val logic = Anagrams(vocabulary, permutations)

    println(logic.computeAnagrams(arg))
}