package studio.forface.recruiteetodoist.api.recruitee

import studio.forface.recruiteetodoist.api.recruitee.model.InterviewEventsApiModel
import studio.forface.recruiteetodoist.api.recruitee.model.ReferenceApiModel.Candidate
import studio.forface.recruiteetodoist.domain.Interview
import studio.forface.recruiteetodoist.domain.Interviews
import java.time.Instant

typealias InterviewEventsApiToDomainMapper = (InterviewEventsApiModel) -> Interviews

val InterviewsEventsToDomainModel = object : InterviewEventsApiToDomainMapper {

    override fun invoke(events: InterviewEventsApiModel) = Interviews(
        past = events.meta.counters.past,
        upcoming = events.interviewEvents.map { event ->
            val candidate = events.references
                .filterIsInstance<Candidate>()
                .first { it.id == event.candidateId }
            Interview(
                id = event.id,
                candidateName = candidate.name,
                startTime = Instant.parse(event.startsAt),
                candidateUrl = candidate.url,
                interviewUrl = event.syncUrl
            )
        }
    )
}
