package studio.forface.recruiteetodoist.domain

interface TodoistApi {
    suspend fun findTaskFor(interview: Interview): Long?
    suspend fun create(interview: Interview): Long
    suspend fun update(taskId: Long, interview: Interview)
}
