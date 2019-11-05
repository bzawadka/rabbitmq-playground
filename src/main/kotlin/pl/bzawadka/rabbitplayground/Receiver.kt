package pl.bzawadka.rabbitplayground

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.rabbit.annotation.RabbitHandler

@RabbitListener(queues = ["myqueue"])
class Receiver {

    @RabbitHandler
    fun receive(msg: String) {
        println(" [x] Received '$msg'")
    }
}
