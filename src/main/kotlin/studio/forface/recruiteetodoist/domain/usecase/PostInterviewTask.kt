package studio.forface.recruiteetodoist.domain.usecase

import studio.forface.recruiteetodoist.api.todoist.TodoistApi
import studio.forface.recruiteetodoist.domain.Interview
import studio.forface.recruiteetodoist.domain.TodoistApi

/**
 * Create or Update Interview Task
 *
 * # Input:
 *   [Interview]
 */
class PostInterviewTask(
    private val api: TodoistApi = TodoistApi()
) {

    suspend operator fun invoke(interview: Interview) {
        api.findTaskFor(interview)
            ?.let { api.update(it, interview) }
            ?: api.create(interview)
    }
}
