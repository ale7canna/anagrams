package ale7canna.anagrams

class Anagrams(
    private val vocabulary: List<String>,
    private val permutations: Permutations
) {
    fun computeAnagrams(s: String): List<String> =
        permutations.compute(s)
            .flatMap {
                val splitWords = it.split(" ")
                val isValid = splitWords.all { word ->
                    vocabulary.binarySearch(word, String.CASE_INSENSITIVE_ORDER) >= 0 }
                val wordsToPermute =
                    if (isValid)
                        splitWords
                    else
                        emptyList()
                permutations.compute(wordsToPermute)
                    .map { wordsPermutations ->
                        wordsPermutations.joinToString(" ")
                    }
                    .filter { r -> r.length == s.length }
            }
            .distinct()

}
