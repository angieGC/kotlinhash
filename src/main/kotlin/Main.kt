package com.joom.xxhash

import java.util.Random

fun main(args: Array<String>) {
    val random = Random()
    val seed = if (random.nextBoolean()) random.nextLong() else null
    println("Hello lok!")
    val actualHash = XxHash64Hasher(seed).run {
        hash.digest()
    }

    val expectedHash = ByteArrayHasher().run {
        if (seed == null) XxHash64.hashForArray(toByteArray()) else XxHash64.hashForArray(toByteArray(), seed)
    }

    if (expectedHash != actualHash) {
        println("Expected $expectedHash, actual $actualHash, seed = $seed")
    }

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}