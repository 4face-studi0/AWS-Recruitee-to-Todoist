package studio.forface.recruiteetodoist.api.todoist.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommentRequestApiModel(

    @SerialName("task_id")
    val taskId: Long,

    @SerialName("content")
    val content: String
)
