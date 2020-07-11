package studio.forface.recruiteetodoist.api.recruitee

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.features.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.http.URLProtocol
import kotlinx.serialization.UnstableDefault
import studio.forface.recruiteetodoist.RECRUITEE_COMPANY_ID
import studio.forface.recruiteetodoist.RECRUITEE_TOKEN
import studio.forface.recruiteetodoist.api.httpClient
import studio.forface.recruiteetodoist.api.recruitee.model.InterviewEventsApiModel
import studio.forface.recruiteetodoist.domain.Interviews
import studio.forface.recruiteetodoist.domain.RecruiteeApi

fun RecruiteeApi(
    service: RecruiteeService = RecruiteeService(),
    toDomainModel: InterviewEventsApiToDomainMapper = InterviewsEventsToDomainModel
) : RecruiteeApi = RecruiteeApiImpl(service, toDomainModel)

private class RecruiteeApiImpl(
    private val service: RecruiteeService = RecruiteeService(),
    private val toDomainModel: InterviewEventsApiToDomainMapper = InterviewsEventsToDomainModel
) : RecruiteeApi {

    override suspend fun upcomingInterviews(): Interviews =
        toDomainModel(service.upcomingInterviews())
}

@OptIn(UnstableDefault::class)
class RecruiteeService(
    client: HttpClient = httpClient,
    config: HttpClientConfig<*>.() -> Unit = {

        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.recruitee.com/c/$RECRUITEE_COMPANY_ID"
            }
            header("authorization", "Bearer $RECRUITEE_TOKEN")
        }
    }
) {
    private val client = client.config(config)

    suspend fun upcomingInterviews() = _upcomingInterviews<InterviewEventsApiModel>()
    suspend fun upcomingInterviewsJson() = _upcomingInterviews<String>()

    @Suppress("FunctionName")
    private suspend inline fun <reified T> _upcomingInterviews() = client.get<T> {
        url {
            path("interview", "events")
            parameter("scope", "my")
            parameter("status", "upcoming")
        }
    }
}
