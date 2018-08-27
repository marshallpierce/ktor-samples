package io.ktor.samples.html

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.routing.*
import kotlinx.html.*

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    install(StatusPages)
    routing {
        get("/") {
            call.respondHtml {
                head {
                    title { +"Ktor: html" }
                }
                body {
                    p {
                        +"Hello from Ktor html sample application"
                    }
                    throw RuntimeException("kaboom")
                    widget {
                        +"Widgets are just functions"
                    }
                }
            }
        }
    }
}

@HtmlTagMarker
fun FlowContent.widget(body: FlowContent.() -> Unit) {
    div { body() }
}
