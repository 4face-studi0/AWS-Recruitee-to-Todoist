package studio.forface.recruiteetodoist.domain

interface RecruiteeApi {
    suspend fun upcomingInterviews(): Interviews
}
