package pl.bzawadka.rabbitplayground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitPlaygroundApplication

fun main(args: Array<String>) {
	runApplication<RabbitPlaygroundApplication>(*args)
}
