package studio.forface.recruiteetodoist.api.recruitee.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RatingsApiModel(
    @SerialName("strong_yes")
    val strongYes: Int // 1
)
