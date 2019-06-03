import ale7canna.anagrams.Anagrams
import ale7canna.anagrams.Permutations
import io.kotlintest.matchers.collections.shouldBeSortedWith
import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class AnagramsTest : StringSpec() {
    init {
        val vocabulary = listOf(
            "a",
            "aab",
            "abb",
            "b"
        )
        val permutations = Permutations()
        val sut = Anagrams(vocabulary, permutations)

        "Anagrams should map permutations on a dictionary" {
            var result = sut.computeAnagrams("aa bb")

            result shouldContain "a abb"
            result shouldContain "b aab"
            result shouldContain "abb a"
            result shouldContain "aab b"
        }
    }
}