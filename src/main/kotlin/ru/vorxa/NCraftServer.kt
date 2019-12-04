package ru.vorxa

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.NotFoundException
import io.ktor.features.ParameterConversionException
import io.ktor.features.StatusPages
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.*
import io.ktor.server.cio.EngineMain
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import org.kodein.di.ktor.KodeinFeature
import ru.vorxa.repository.PostRepository
import ru.vorxa.repository.PostRepositoryMutexImpl
import ru.vorxa.route.v1
import java.lang.NullPointerException

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            serializeNulls()
        }
    }
    install(StatusPages) {
        exception<NotImplementedError> {
            call.respond(HttpStatusCode.NotImplemented)
        }
        exception<Throwable> {
            call.respond(HttpStatusCode.InternalServerError)
        }
        exception<ParameterConversionException> {
            call.respond(HttpStatusCode.BadRequest)
        }
        exception<NotFoundException> {
            call.respond(HttpStatusCode.BadRequest)
        }
        exception<NullPointerException> {
            call.respond(HttpStatusCode.PaymentRequired)
        }
    }
    install(KodeinFeature) {

        bind<PostRepository>() with singleton { PostRepositoryMutexImpl() }
    }

    install(Routing) {
        v1()
    }
}