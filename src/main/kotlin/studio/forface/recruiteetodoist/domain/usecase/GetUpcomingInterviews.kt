package studio.forface.recruiteetodoist.domain.usecase

import studio.forface.recruiteetodoist.api.recruitee.RecruiteeApi
import studio.forface.recruiteetodoist.domain.Interviews
import studio.forface.recruiteetodoist.domain.RecruiteeApi

/**
 * Get Upcoming scheduled Interviews
 *
 * # Output:
 *   [Interviews]
 */
class GetUpcomingInterviews(
    private val api: RecruiteeApi = RecruiteeApi()
) {

    suspend operator fun invoke() =
        api.upcomingInterviews()
}
