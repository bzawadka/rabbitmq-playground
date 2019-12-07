package pl.bzawadka.rabbitplayground.example2

import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Profile("example-2")
@Configuration
class Config {

    @Bean
    fun hello(): Queue = Queue("tasks")

    @Profile("receiver")
    class ReceiverConfig {

        @Bean
        fun receiver1() = Receiver(1)

        @Bean
        fun receiver2() = Receiver(2)
    }


    @Profile("sender")
    @Bean
    fun sender() = Sender()

}