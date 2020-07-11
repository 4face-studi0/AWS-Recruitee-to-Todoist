package studio.forface.recruiteetodoist.api.todoist.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TaskResponseApiModel(

    @SerialName("id")
    val id: Long
)
