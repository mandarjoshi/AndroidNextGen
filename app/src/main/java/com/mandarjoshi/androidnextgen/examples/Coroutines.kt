package com.mandarjoshi.androidnextgen.examples

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    println("Current Thread start "+Thread.currentThread().name)

        

    println("Current Thread end "+Thread.currentThread().name)
}

/*
fun main() = runBlocking {
    println("Current Thread start "+Thread.currentThread().name)

    println("$this")

    launch {
        println("$this")
        launch {
            println("child $this")
        }

    }

    async {
        println("$this")
    }

    println("Current Thread end "+Thread.currentThread().name)
}*/

/*
fun main() = runBlocking {
    println("Current Thread start "+Thread.currentThread().name)

    val one = async(start = CoroutineStart.LAZY) { messageOne() }
    val two = async(start = CoroutineStart.LAZY) { messageTwo() }
    println("${one.await()} ${two.await()}")

    println("Current Thread end "+Thread.currentThread().name)
}*/

/*
fun main() = runBlocking {
    println("Current Thread start "+Thread.currentThread().name)
    val time = measureTimeMillis {
        val one = async { messageOne() }
        val two = async { messageTwo() }
        println("${one.await()} ${two.await()}")
    }
    println("time: $time")
    println("Current Thread end "+Thread.currentThread().name)
}*/

suspend fun messageOne(): String{
    delay(1000)
    println("In messageOne")
    return "Hello"
}

suspend fun messageTwo(): String{
    delay(1000)
    println("In messageTwo")
    return "World!"
}

/*
fun main() = runBlocking {
        println("Current Thread start "+Thread.currentThread().name)


    withTimeoutOrNull(200){
        for(i in 1..500){
            print("$i ")
            delay(50)
        }
    }

        val job = launch {
            println("Inside Thread start "+Thread.currentThread().name)
            try {
                for(i in 1..500){
                    print("$i ")
                    delay(1)
                }
            } catch (e: CancellationException){
                println("\n${e.localizedMessage}")
            }finally {
                withContext(NonCancellable){
                    delay(100)
                    println("finally called")
                }
            }
            println("Inside Thread finished "+Thread.currentThread().name)

        }
        delay(10)
        job.cancelAndJoin()

        println("Current Thread end "+Thread.currentThread().name)
}*/

class Coroutines {
    suspend fun myFunction(time: Long): Long{
        delay(time)
        return time * 2
    }
}