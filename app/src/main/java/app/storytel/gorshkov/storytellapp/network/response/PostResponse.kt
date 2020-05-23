package app.storytel.gorshkov.storytellapp.network.response

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val id: Int,
    val title: String,
    val body: String
)