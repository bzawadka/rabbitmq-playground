package pl.bzawadka.rabbitplayground

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.context.ConfigurableApplicationContext

class MyCommandLineRunner : CommandLineRunner {

    @Value("\${tutorial.client.duration:0}")
    private val duration: Int = 0

    @Autowired
    private val ctx: ConfigurableApplicationContext? = null

    override fun run(vararg args: String?) {
        println("Ready ... running for " + duration + "ms");
        Thread.sleep(duration.toLong());
        ctx?.close();
    }
}
