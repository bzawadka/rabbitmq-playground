package pl.bzawadka.rabbitplayground.example1

import org.springframework.amqp.core.Queue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.scheduling.annotation.Scheduled
import kotlin.random.Random

class Sender {

    @Autowired
    private val template: RabbitTemplate? = null

    @Autowired
    private val queue: Queue? = null

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    fun send() {
        val id: Char = Random.nextInt(65, 90).toChar()
        val message = "Hello $id"
        this.template?.convertAndSend(queue?.name!!, message)
        println(" [x] Sent '$message'")
    }
}

// https://www.rabbitmq.com/tutorials/tutorial-two-spring-amqp.html