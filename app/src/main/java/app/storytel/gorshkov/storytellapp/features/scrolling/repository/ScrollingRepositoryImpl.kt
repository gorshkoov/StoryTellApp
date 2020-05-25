package app.storytel.gorshkov.storytellapp.features.scrolling.repository

import app.storytel.gorshkov.storytellapp.features.scrolling.items.ScrollingItem
import app.storytel.gorshkov.storytellapp.network.service.PostsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ScrollingRepositoryImpl(
    private val service: PostsService
) : ScrollingRepository {

    override fun getPosts(): Flow<List<ScrollingItem>> = flow {
        val posts = service.getPosts()
        val photos = service.getPhotos()
        val items = posts.map {post->
            val photo = photos.find { photo -> photo.id == post.id }
            ScrollingItem(post.id, post.title, post.body, photo?.url, photo?.thumbnailUrl)
        }
        emit(items)
    }.flowOn(Dispatchers.IO)

}