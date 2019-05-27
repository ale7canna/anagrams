package ale7canna.anagrams

class Permutations {
    fun compute(s: String): List<String> =
        compute(s.toCharArray().map { it })
            .map { String(it.toCharArray()) }

    private fun <T> compute(list: List<T>): List<List<T>> =
        list.mapIndexed { index, t ->
            compute(
                listOf(listOf(t)),
                list.removeAt(index)) }
            .flatten()

    private fun <T> compute(acc: List<List<T>>, list: List<T>): List<List<T>> =
        when {
            list.count() == 0 -> acc
            else -> list.mapIndexed { index, item ->
                compute(acc.map { it + listOf(item) }, list.removeAt(index))
            }.flatten()
        }

    private fun <T> List<T>.removeAt(index: Int): List<T> =
        this.take(index) + this.drop(index + 1)
}
