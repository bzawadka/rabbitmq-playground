package pl.bzawadka.rabbitplayground.example2

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.util.StopWatch

@RabbitListener(queues = ["tasks"])
class Receiver(private val id: Int) {
    init {
        println("Receiver $id initialized")
    }

    @RabbitHandler
    @Throws(InterruptedException::class)
    fun receive(message: String) {
        val watch = StopWatch()
        watch.start()

        println("instance $id [x] Received  '$message'")
        simulateProcessingOf(message)

        watch.stop()
        println("instance $id [x] Processed '$message' in ${watch.totalTimeSeconds.toInt()}s")
    }

    @Throws(InterruptedException::class)
    private fun simulateProcessingOf(message: String) {
        message.toCharArray().filter { c -> c == '.' }.forEach { _ -> Thread.sleep(1000) }
    }
}
