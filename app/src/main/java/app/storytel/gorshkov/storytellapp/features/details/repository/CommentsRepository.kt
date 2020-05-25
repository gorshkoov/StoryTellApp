package app.storytel.gorshkov.storytellapp.features.details.repository

import app.storytel.gorshkov.storytellapp.features.details.items.CommentItem
import kotlinx.coroutines.flow.Flow

interface CommentsRepository {
    fun getComments(postId: Int): Flow<List<CommentItem>>
}