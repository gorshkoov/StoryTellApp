package app.storytel.gorshkov.storytellapp.mapper

import app.storytel.gorshkov.storytellapp.features.details.items.CommentItem
import app.storytel.gorshkov.storytellapp.network.response.CommentResponse

fun CommentResponse.mapToCommentItem(): CommentItem = CommentItem(name, body)