package pl.bzawadka.rabbitplayground.example1

import org.springframework.amqp.core.Queue
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Profile("example-1")
@Configuration
class Config {

    @Bean
    fun hello(): Queue = Queue("myqueue")

    @Profile("receiver")
    @Bean
    fun receiver() = Receiver()

    @Profile("sender")
    @Bean
    fun sender() = Sender()

}