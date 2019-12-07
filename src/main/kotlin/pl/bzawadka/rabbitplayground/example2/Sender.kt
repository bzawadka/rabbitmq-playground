package pl.bzawadka.rabbitplayground.example2

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import java.util.concurrent.atomic.AtomicInteger

class Sender {
    @Autowired
    private val template: RabbitTemplate? = null

    @Autowired
    private val queue: Queue? = null

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    fun send() {
        val message = generateMessage()
        this.template?.convertAndSend(queue?.name!!, message)
        println(" [x] Sent '$message'")
    }

    private fun generateMessage(): String {
        if (dotsCounter.incrementAndGet() > 5) {
            dotsCounter.set(1)
        }

        val builder = StringBuilder("Task")
        (0 until dotsCounter.get()).forEach { _ -> builder.append('.') }
        builder.append(messageId.incrementAndGet())
        return builder.toString()
    }

    private val dotsCounter = AtomicInteger(0)
    private val messageId = AtomicInteger(0)
}

// https://www.rabbitmq.com/tutorials/tutorial-two-spring-amqp.html