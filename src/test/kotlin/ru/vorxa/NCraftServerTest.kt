package ru.vorxa

import io.ktor.http.ContentType
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.withCharset
import io.ktor.server.testing.contentType
import kotlinx.io.charsets.Charset
import org.junit.Test
import kotlin.test.assertEquals

class NCraftServerTest {
    private val jsonContentType = ContentType.Application.Json.withCharset(Charset.forName("UTF-8"))

    @Test
    fun testGetAll() {
        withTestApplication({ module() }) {
            handleRequest(HttpMethod.Get, "/api/v1/posts").run {
                assertEquals(HttpStatusCode.OK, this.response.status())
                assertEquals(jsonContentType, this.response.contentType())
            }
        }
    }
}