package studio.forface.recruiteetodoist.domain

import java.time.Instant

data class Interviews(
    val past: Int,
    val upcoming: Collection<Interview>
)

data class Interview(
    val id: Long,
    val candidateName: String,
    val startTime: Instant,
    val candidateUrl: String,
    val interviewUrl: String
)
