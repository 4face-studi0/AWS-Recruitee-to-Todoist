package studio.forface.recruiteetodoist.api.recruitee

import kotlinx.coroutines.runBlocking
import kotlin.test.Test

internal class RecruiteeServiceTest {

    @Test
    fun `test json`() = runBlocking {
        with(RecruiteeService()) {
            println()
            println(upcomingInterviewsJson())
            println()
            println(upcomingInterviews())
            println()
        }
    }

}
