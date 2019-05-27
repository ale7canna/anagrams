import ale7canna.anagrams.Permutations
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class PermutationsTest : StringSpec() {
    init {
        val sut = Permutations()
        "should compute anagrams for a" {
            sut.compute("a") shouldBe listOf("a")
        }

        "should compute anagrams for aa" {
            sut.compute("aa") shouldBe listOf("aa", "aa")
        }

        "should compute anagrams for ab" {
            sut.compute("ab") shouldBe listOf("ab", "ba")
        }

        "should compute anagrams for abc" {
            sut.compute("abc") shouldBe listOf(
                "abc", "acb",
                "bac", "bca",
                "cab", "cba")
        }

        "should compute anagrams for abcd" {
            sut.compute("abcd") shouldBe listOf(
                "abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
                "bacd", "badc", "bcad", "bcda", "bdac", "bdca",
                "cabd", "cadb", "cbad", "cbda", "cdab", "cdba",
                "dabc", "dacb", "dbac", "dbca", "dcab", "dcba"
            )
        }
    }
}