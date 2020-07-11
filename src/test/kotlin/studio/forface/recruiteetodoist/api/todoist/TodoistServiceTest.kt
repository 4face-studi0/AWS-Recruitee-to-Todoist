package studio.forface.recruiteetodoist.api.todoist

import kotlinx.coroutines.runBlocking
import studio.forface.recruiteetodoist.api.todoist.model.CommentRequestApiModel
import studio.forface.recruiteetodoist.api.todoist.model.TaskRequestApiModel
import studio.forface.recruiteetodoist.api.todoist.model.TaskUpdateRequestApiModel
import kotlin.random.Random
import kotlin.test.Test

internal class TodoistServiceTest {

    private val service = TodoistService()

    @Test
    fun `get tasks`() = runBlocking {
        with(service) {
            println()
            println(allInterviewsJson())
            println()
            println(allInterviews())
            println()
        }
    }

    @Test
    fun `create new task`() {
        runBlocking {

            val response = service.create(
                TaskRequestApiModel(
                    content = "Interview with Hello ${Random.nextInt(100)}!",
                    dueDate = "2020-07-20T08:00:00Z"
                )
            )

            println()
            println(response)
        }
    }

    @Test
    fun `update task`() {
        runBlocking {

            service.allInterviews().random().let {

                service.update(
                    it.id,
                    TaskUpdateRequestApiModel(
                        content = "Interview with Updated ${Random.nextInt(100)}!",
                        dueDate = "2020-07-19T08:00:00Z"
                    )
                )
            }
        }
    }

    @Test
    fun `create new comment`() {
        runBlocking {

            service.create(CommentRequestApiModel(4030174850, "Hello comment"))
        }
    }
}
