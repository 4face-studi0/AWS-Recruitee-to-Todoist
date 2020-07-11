package studio.forface.recruiteetodoist.api.todoist

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import studio.forface.recruiteetodoist.api.todoist.model.CommentRequestApiModel
import studio.forface.recruiteetodoist.api.todoist.model.TaskRequestApiModel
import studio.forface.recruiteetodoist.api.todoist.model.TaskResponseApiModel
import studio.forface.recruiteetodoist.api.todoist.model.TaskUpdateRequestApiModel
import studio.forface.recruiteetodoist.domain.Interview
import java.time.Instant
import java.time.temporal.ChronoUnit
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

internal class TodoistApiImplTest {

    private val api = TodoistApi(MockService)

    @Test
    fun `create task with comments`() {
        runBlocking {

            val interview = Interview(
                id = 123,
                candidateName = "Davide Farella",
                startTime = Instant.now().plus(2, ChronoUnit.DAYS),
                candidateUrl = "https://candidate_url",
                interviewUrl = "https://interview_url"
            )

            api.create(interview)

            assertNotNull(api.findTaskFor(interview))
        }
    }

    @Test
    fun `update task`() {
        runBlocking {

            val now = Instant.now()
            val interview = Interview(
                id = 123,
                candidateName = "Davide Farella",
                startTime = now.plus(2, ChronoUnit.DAYS),
                candidateUrl = "https://candidate_url",
                interviewUrl = "https://interview_url"
            )

            val taskId = api.create(interview)
            api.update(taskId, interview.copy(startTime = now.plus(3, ChronoUnit.DAYS)))

            assertEquals(taskId, api.findTaskFor(interview))
        }
    }

    private val MockService get() = mockk<TodoistService> {

        val tasks = mutableMapOf<Long, MutableMap<String, Any>>()
        @Suppress("UNCHECKED_CAST")
        fun Map<String, Any>?.comments() = this!!["comments"] as MutableList<String>

        // Create task
        coEvery { create(any<TaskRequestApiModel>()) } answers {
            val request = firstArg<TaskRequestApiModel>()
            val id = Random.nextLong()
            tasks[id] = mutableMapOf(
                "content" to request.content,
                "date" to request.dueDate,
                "comments" to mutableListOf<String>()
            )
            TaskResponseApiModel(id)
        }

        // Update task
        coEvery { update(any(), any()) } answers {
            val request = secondArg<TaskUpdateRequestApiModel>()
            val id = firstArg<Long>()
            tasks.getValue(id).let {
                it["content"] = request.content
                it["date"] = request.dueDate
            }
            TaskResponseApiModel(id)
        }

        // Create comment
        coEvery { create(any<CommentRequestApiModel>()) } answers {
            val request = firstArg<CommentRequestApiModel>()
            tasks[request.taskId].comments() += request.content
        }

        // Get a task
        coEvery { get(any<Long>()) } answers {
            val query = "Interview id: ${firstArg<Long>()}"
            val matchingTasks = tasks.filterValues { query in it.comments() }

            matchingTasks.map {
                TaskResponseApiModel(it.key)
            }
        }
    }
}
