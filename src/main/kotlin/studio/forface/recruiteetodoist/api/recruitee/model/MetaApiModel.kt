package studio.forface.recruiteetodoist.api.recruitee.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MetaApiModel(
    @SerialName("counters")
    val counters: CountersApiModel
)
