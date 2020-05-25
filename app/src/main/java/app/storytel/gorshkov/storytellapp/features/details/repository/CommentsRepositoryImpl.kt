package app.storytel.gorshkov.storytellapp.features.details.repository

import app.storytel.gorshkov.storytellapp.features.details.items.CommentItem
import app.storytel.gorshkov.storytellapp.mapper.mapToCommentItem
import app.storytel.gorshkov.storytellapp.network.service.PostsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CommentsRepositoryImpl(
    private val service: PostsService
): CommentsRepository {

    override fun getComments(postId: Int): Flow<List<CommentItem>> = flow {
        val response = service.getComments(postId)
        val items = response
            .take(3)
            .map { it.mapToCommentItem() }
        emit(items)
    }.flowOn(Dispatchers.IO)
}