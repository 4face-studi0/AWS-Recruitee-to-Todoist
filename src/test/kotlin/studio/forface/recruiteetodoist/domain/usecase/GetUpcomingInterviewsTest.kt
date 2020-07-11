package studio.forface.recruiteetodoist.domain.usecase

import kotlinx.coroutines.runBlocking
import kotlin.test.Test

internal class GetUpcomingInterviewsTest {

    @Test
    fun `verify upcoming interviews`() = runBlocking {
        val interviews = GetUpcomingInterviews().invoke()

        println()
        println(interviews)
        println()
    }
}
