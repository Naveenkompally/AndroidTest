package com.jtpl.alogorithamtask

object NumberUtils {

    fun getOddNumbers(limits: Int): Set<Int> {
        return (1..limits step 2).toSet()
    }

    fun getEvenNumbers(limits: Int): Set<Int> {
        return (2..limits step 2).toSet()
    }

    fun getPrimeNumbers(limits: Int): Set<Int> {
        val isPrime = BooleanArray(limits + 1) { true }
        isPrime[0] = false
        isPrime[1] = false
        for (p in 2..Math.sqrt(limits.toDouble()).toInt()) {
            for (i in p * p..limits step p) {
                isPrime[i] = false
            }
        }
        return (2..limits).filter { isPrime[it] }.toSet()
    }

    fun getFibonacciNumbers(limits: Int): Set<Int> {

        val result = mutableSetOf<Int>()
        var a = 0
        var b = 1
        while (a <= limits) {
            result.add(a)
            val next = a + b
            a = b
            b = next
        }
        return result
    }

}