import mu.KotlinLogging


private val logger =  KotlinLogging.logger {
}
fun main() {

    println("Logger")

    logger.trace { "trace" }
    logger.debug { "Debug" }
    logger.info { "info" }
    logger.warn { "warning" }
    logger.error { "error" }


}
