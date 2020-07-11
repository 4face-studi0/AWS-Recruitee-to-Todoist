package studio.forface.recruiteetodoist.api.todoist

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.features.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.http.URLProtocol
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import studio.forface.recruiteetodoist.TODOIST_TOKEN
import studio.forface.recruiteetodoist.api.httpClient
import studio.forface.recruiteetodoist.api.todoist.model.CommentRequestApiModel
import studio.forface.recruiteetodoist.api.todoist.model.TaskRequestApiModel
import studio.forface.recruiteetodoist.api.todoist.model.TaskResponseApiModel
import studio.forface.recruiteetodoist.api.todoist.model.TaskUpdateRequestApiModel
import studio.forface.recruiteetodoist.domain.Interview
import studio.forface.recruiteetodoist.domain.TodoistApi

fun TodoistApi(
    service: TodoistService = TodoistService(),
    toInterviewTask: InterviewTaskDomainToApiMapper = InterviewToTaskApiModel,
    toInterviewTaskUpdate: InterviewTaskUpdateDomainToApiMapper = InterviewToTaskUpdateApiModel,
    toTaskComments: InterviewCommentsApiMapper = InterviewToCommentsApiModel
) : TodoistApi = TodoistApiImpl(service, toInterviewTask, toInterviewTaskUpdate, toTaskComments)

private class TodoistApiImpl(
    private val service: TodoistService = TodoistService(),
    private val toInterviewTask: InterviewTaskDomainToApiMapper = InterviewToTaskApiModel,
    private val toInterviewTaskUpdate: InterviewTaskUpdateDomainToApiMapper = InterviewToTaskUpdateApiModel,
    private val toTaskComments: InterviewCommentsApiMapper = InterviewToCommentsApiModel
) : TodoistApi {

    override suspend fun findTaskFor(interview: Interview) =
        service.get(interview.id).firstOrNull()?.id

    override suspend fun create(interview: Interview) = coroutineScope {
        val createdTask = service.create(toInterviewTask(interview))
        val jobs = toTaskComments(interview, createdTask.id).map {
            launch { service.create(it) }
        }

        joinAll(*jobs.toTypedArray())
        createdTask.id
    }

    override suspend fun update(taskId: Long, interview: Interview) {
        service.update(taskId, toInterviewTaskUpdate(interview))
    }

}

class TodoistService(
    client: HttpClient = httpClient,
    config: HttpClientConfig<*>.() -> Unit = {

        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.todoist.com/rest/v1"
            }
            header("authorization", "Bearer $TODOIST_TOKEN")
        }
    }
) {
    private val client = client.config(config)

    suspend fun allInterviews() = _allInterviews<List<TaskResponseApiModel>>()
    suspend fun allInterviewsJson() = _allInterviews<String>()

    suspend fun get(interviewId: Long) = client.get<List<TaskResponseApiModel>> {
        url {
            path("tasks")
            parameter("filter", "label:Proton&search:Interview id: $interviewId")
        }
    }

    suspend fun create(task: TaskRequestApiModel) = client.post<TaskResponseApiModel> {
        url.path("tasks")
        headers
            .append("Content-Type", "application/json")
        body = task
    }

    suspend fun update(taskId: Long, task: TaskUpdateRequestApiModel) = client.post<Unit> {
        url.path("tasks", "$taskId")
        headers
            .append("Content-Type", "application/json")
        body = task
    }

    suspend fun create(comment: CommentRequestApiModel) = client.post<Unit> {
        url.path("comments")
        headers
            .append("Content-Type", "application/json")
        body = comment
    }

    @Suppress("FunctionName")
    private suspend inline fun <reified T> _allInterviews() = client.get<T> {
        url {
            path("tasks")
            parameter("filter", "label:Proton&search:Interview with")
        }
    }
}
