package studio.forface.recruiteetodoist.api.recruitee.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountersApiModel(
    @SerialName("past_due")
    val past: Int, // 12
    @SerialName("upcoming")
    val upcoming: Int // 1
)
