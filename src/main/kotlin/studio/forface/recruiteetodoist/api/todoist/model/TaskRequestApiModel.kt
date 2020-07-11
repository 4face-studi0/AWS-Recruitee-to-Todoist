package studio.forface.recruiteetodoist.api.todoist.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TaskRequestApiModel(

    @SerialName("content")
    val content: String,

    @SerialName("project_id")
    val projectId: Long = 1777124480,

    @SerialName("label_ids")
    val labelIds: Set<Long> = setOf(2154046542),

    @SerialName("due_datetime")
    val dueDate: String
)

@Serializable
data class TaskUpdateRequestApiModel(

    @SerialName("content")
    val content: String,

    @SerialName("due_datetime")
    val dueDate: String
)
