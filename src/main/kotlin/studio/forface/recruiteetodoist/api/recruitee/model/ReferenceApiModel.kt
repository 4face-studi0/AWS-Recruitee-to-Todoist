package studio.forface.recruiteetodoist.api.recruitee.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class ReferenceApiModel {

    @Serializable
    @SerialName("Admin")
    data class Admin(
        val email: String
    ) : ReferenceApiModel()

    @Serializable
    @SerialName("Candidate")
    data class Candidate(

        @SerialName("id")
        val id: Long,

        @SerialName("name")
        val name: String,

        @SerialName("adminapp_url")
        val url: String // https://app.recruitee.com/#/dashboard/overview?candidate=16737078&company=29808

    ) : ReferenceApiModel()

    @Serializable
    @SerialName("Offer")
    data class Offer(
        val title: String
    ) : ReferenceApiModel()

    @Serializable
    @SerialName("Stage")
    data class Stage(
        val category: String
    ) : ReferenceApiModel()

//    @SerialName("email")
//    val email: String, // marija@protonmail.com
//    @SerialName("first_name")
//    val firstName: String, // Marija
//    @SerialName("id")
//    val id: Int, // 80432
//    @SerialName("last_name")
//    val lastName: String, // Ristova
//    @SerialName("photo_normal_url")
//    val photoNormalUrl: String, // https://recruitee-main.s3.eu-central-1.amazonaws.com/admins/80432/normal_avatar_1551949394.png
//    @SerialName("photo_thumb_url")
//    val photoThumbUrl: String, // https://recruitee-main.s3.eu-central-1.amazonaws.com/admins/80432/thumb_avatar_1551949394.png
//    @SerialName("time_format24")
//    val timeFormat24: Boolean, // true
//    @SerialName("timezone")
//    val timezone: String, // Europe/Skopje
//    @SerialName("type")
//    val type: String, // Admin
//    @SerialName("admin_id")
//    val adminId: Any, // null
//    @SerialName("created_at")
//    val createdAt: String, // 2020-05-13T15:14:36.819060Z
//    @SerialName("emails")
//    val emails: List<String>,
//    @SerialName("example")
//    val example: Boolean, // false
//    @SerialName("last_message_at")
//    val lastMessageAt: Any, // null
//    @SerialName("name")
//    val name: String, // Marc Gilbert
//    @SerialName("notes_count")
//    val notesCount: Int, // 4
//    @SerialName("pending_result_request")
//    val pendingResultRequest: Boolean, // false
//    @SerialName("phones")
//    val phones: List<String>,
//    @SerialName("positive_ratings")
//    val positiveRatings: Int, // 100
//    @SerialName("rating")
//    val rating: Double, // 0.0
//    @SerialName("ratings")
//    val ratings: RatingsApiModel,
//    @SerialName("ratings_count")
//    val ratingsCount: Int, // 1
//    @SerialName("referrer")
//    val referrer: String, // neuvoo.ch
//    @SerialName("source")
//    val source: String, // career_site
//    @SerialName("tasks_count")
//    val tasksCount: Int, // 0
//    @SerialName("upcoming_event")
//    val upcomingEvent: Boolean, // true
//    @SerialName("updated_at")
//    val updatedAt: String, // 2020-07-10T08:45:37.107334Z
//    @SerialName("viewed")
//    val viewed: Boolean, // true
//    @SerialName("kind")
//    val kind: String, // job
//    @SerialName("lang_code")
//    val langCode: String, // en
//    @SerialName("location")
//    val location: String, // Skopje, Vilnius, Zurich, Geneva, Taipei, Taiwan
//    @SerialName("position")
//    val position: Int, // 73
//    @SerialName("slug")
//    val slug: String, // senior-android-developer
//    @SerialName("status")
//    val status: String, // published
//    @SerialName("title")
//    val title: String, // Senior Android Developer
//    @SerialName("action_templates")
//    val actionTemplates: List<Any>,
//    @SerialName("category")
//    val category: String, // interview
//    @SerialName("locked")
//    val locked: Boolean, // false
//    @SerialName("placements_count")
//    val placementsCount: Any, // null
//    @SerialName("time_limit")
//    val timeLimit: Any // null
}
