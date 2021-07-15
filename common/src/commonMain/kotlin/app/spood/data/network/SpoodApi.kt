package app.spood.data.network

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.core.*
import io.ktor.client.features.json.*

class SpoodApi(
    private val client: HttpClient = HttpClient() {
        install(JsonFeature) { serializer = GsonSerializer() }
    }
) {

    suspend fun signUp(fullName: String, phoneNumber: String): String {
        val token: TokenDto = client.use {
            it.post("https://reqres.in/api/login") {
                headers { append(HttpHeaders.Authorization, "Api-Token") }
                parameter("page", "2")
                contentType(ContentType.Application.Json)
                body = SignUpDto(
                    "eve.holt@reqres.in",
                    "cityslicka",
                )
            }
        }

        return token.token
    }
}