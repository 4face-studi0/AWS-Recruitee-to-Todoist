package studio.forface.recruiteetodoist.api.recruitee.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InterviewEventsApiModel(

    @SerialName("interview_events")
    val interviewEvents: List<InterviewEventApiModel>,

    @SerialName("meta")
    val meta: MetaApiModel,

    @SerialName("references")
    val references: List<ReferenceApiModel>
)
