package org.example

class Alphabets {
    private var previousString = ""

    fun generateAlphabets(n: Int): String {
        require(n in 1..26) { "Input must be between 1 and 26" }

        val sb = StringBuilder(previousString)
        var currentChar = if (previousString.isEmpty()) 'A' else previousString.last() + 1

        repeat(n) {
            sb.append(currentChar)
            currentChar++
        }

        previousString = sb.toString()
        return previousString
    }
}

fun main() {
    val alphabetGenerator = Alphabets()

    println("Enter a number between 1 and 26:")
    val input = readlnOrNull()?.toIntOrNull()

    if (input != null) {
        println("Result: ${alphabetGenerator.generateAlphabets(input)}")
    } else {
        println("Invalid input.")
    }
}