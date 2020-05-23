package app.storytel.gorshkov.storytellapp.features.scrolling.repository

import app.storytel.gorshkov.storytellapp.features.scrolling.items.ScrollingItem
import app.storytel.gorshkov.storytellapp.mapper.mapToScrollingItem
import app.storytel.gorshkov.storytellapp.network.service.ScrollingService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ScrollingRepositoryImpl(
    private val service: ScrollingService
) : ScrollingRepository {

    override fun getPosts(): Flow<List<ScrollingItem>> = flow {
        val response = service.getPosts()
        val items = response.map { it.mapToScrollingItem() }
        emit(items)
    }.flowOn(Dispatchers.IO)

}