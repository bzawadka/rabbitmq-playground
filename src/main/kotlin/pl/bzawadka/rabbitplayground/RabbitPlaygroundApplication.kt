package pl.bzawadka.rabbitplayground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class RabbitPlaygroundApplication

fun main(args: Array<String>) {
    runApplication<RabbitPlaygroundApplication>(*args)
}
