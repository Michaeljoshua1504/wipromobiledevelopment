import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        val result = async {
            computeResult()
        }
        println("Computed result: ${result.await()}")
    }
    Thread.sleep(2000L)  // Keep the JVM alive to wait for the coroutine to complete
}

suspend fun computeResult(): Int {
    delay(1000L)  // Simulate a long-running computation
    return 42
}
