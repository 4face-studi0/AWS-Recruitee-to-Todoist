package studio.forface.recruiteetodoist.api.recruitee.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InterviewEventApiModel(

    @SerialName("id")
    val id: Long, // 445099

    @SerialName("candidate_id")
    val candidateId: Long, // 16737078

    @SerialName("starts_at")
    val startsAt: String, // 2020-07-16T08:00:00.000000Z

    @SerialName("duration")
    val duration: Int, // 60

    @SerialName("sync_url")
    val syncUrl: String // https://api.recruitee.com/share/interview/events/4udvuhh6ckm7/sync

//    @SerialName("admin_id")
//    val adminId: Int, // 80432
//    @SerialName("admin_ids")
//    val adminIds: List<Int>,
//    @SerialName("created_at")
//    val createdAt: String, // 2020-07-10T08:45:30.767145Z
//    @SerialName("event_url")
//    val eventUrl: String, // https://careers.protonmail.com/v/events/4udvuhh6ckm7
//    @SerialName("google_calendar_url")
//    val googleCalendarUrl: String, // https://www.google.com/calendar/render?action=TEMPLATE&dates=20200716T080000Z%2F20200716T090000Z&details=Video+interview%0ACandidate%3A+Marc+Gilbert%0AInterviewers%3A+Dino+Kadrikj%2C+Davide+Giuseppe+Farella%0AEvent%3A+https%3A%2F%2Fcareers.protonmail.com%2Fv%2Fevents%2F4udvuhh6ckm7&location=&text=Marc+Gilbert+-+Video+interview
//    @SerialName("interview_result_requests")
//    val interviewResultRequests: List<Any>,
//    @SerialName("kind")
//    val kind: String, // video
//    @SerialName("location")
//    val location: Any, // null
//    @SerialName("note")
//    val note: Any, // null
//    @SerialName("offer_id")
//    val offerId: Int, // 457210
//    @SerialName("public_note")
//    val publicNote: Any, // null
//    @SerialName("rescheduled")
//    val rescheduled: Boolean, // false
//    @SerialName("scheduled")
//    val scheduled: Boolean, // true
//    @SerialName("scheduler")
//    val scheduler: String, // Admin
//    @SerialName("stage_id")
//    val stageId: Int, // 4074354
//    @SerialName("timezone")
//    val timezone: String, // Europe/Skopje
//    @SerialName("updated_at")
//    val updatedAt: String, // 2020-07-10T08:45:37.095512Z
//    @SerialName("video_provider")
//    val videoProvider: String, // recruitee
//    @SerialName("video_url")
//    val videoUrl: Any, // null
//    @SerialName("yahoo_calendar_url")
//    val yahooCalendarUrl: String // https://calendar.yahoo.com/?desc=Video+interview%0ACandidate%3A+Marc+Gilbert%0AInterviewers%3A+Dino+Kadrikj%2C+Davide+Giuseppe+Farella%0AEvent%3A+https%3A%2F%2Fcareers.protonmail.com%2Fv%2Fevents%2F4udvuhh6ckm7&dur=0100&in_loc=&st=20200716T080000Z&title=Marc+Gilbert+-+Video+interview&v=60
)
