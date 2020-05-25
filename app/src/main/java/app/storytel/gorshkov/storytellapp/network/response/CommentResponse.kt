package app.storytel.gorshkov.storytellapp.network.response

import kotlinx.serialization.Serializable

@Serializable
data class CommentResponse(
    val name: String,
    val body: String
)