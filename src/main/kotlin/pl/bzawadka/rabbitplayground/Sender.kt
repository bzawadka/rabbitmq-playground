package pl.bzawadka.rabbitplayground

import org.springframework.amqp.core.Queue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.scheduling.annotation.Scheduled

class Sender {

    @Autowired
    private val template: RabbitTemplate? = null

    @Autowired
    private val queue: Queue? = null

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    fun send() {
        val message = "Hello World!"
        this.template?.convertAndSend(queue?.getName()!!, message)
        println(" [x] Sent '$message'")
    }
}

