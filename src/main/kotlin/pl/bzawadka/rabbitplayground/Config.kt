package pl.bzawadka.rabbitplayground

import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Profile("hello-world")
@Configuration
class Config {

    @Bean
    fun hello(): Queue = Queue("myqueue")

    @Profile("receiver")
    @Bean
    fun receiver() : Receiver {
        println("Receiver initialized")
        return Receiver()
    }

    @Profile("sender")
    @Bean
    fun sender() = Sender()

}