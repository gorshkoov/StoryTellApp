package app.storytel.gorshkov.storytellapp.network.response

import kotlinx.serialization.Serializable

@Serializable
data class PhotoResponse(
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)