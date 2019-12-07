package pl.bzawadka.rabbitplayground.example1

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.rabbit.annotation.RabbitHandler

@RabbitListener(queues = ["myqueue"])
class Receiver {
    init {
        println("Receiver initialized")
    }

    @RabbitHandler
    fun receive(message: String) {
        println(" [x] Received '$message'")
    }
}
