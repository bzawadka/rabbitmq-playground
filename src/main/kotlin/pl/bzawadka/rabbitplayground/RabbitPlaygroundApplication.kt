package pl.bzawadka.rabbitplayground

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class RabbitPlaygroundApplication

@Profile("!usage_message")
@Bean
fun runner(): CommandLineRunner = MyCommandLineRunner()

fun main(args: Array<String>) {
	runApplication<RabbitPlaygroundApplication>(*args)
}
