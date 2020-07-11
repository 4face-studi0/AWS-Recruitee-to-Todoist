package studio.forface.recruiteetodoist.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

val httpClient: HttpClient = HttpClient(Apache) {

    install(JsonFeature) {
        serializer = KotlinxSerializer(
            Json(
                JsonConfiguration.Default.copy(
                ignoreUnknownKeys = true
            ))
        )
    }
}
