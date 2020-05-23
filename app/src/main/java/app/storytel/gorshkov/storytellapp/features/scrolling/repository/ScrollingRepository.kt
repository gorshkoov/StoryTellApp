package app.storytel.gorshkov.storytellapp.features.scrolling.repository

import app.storytel.gorshkov.storytellapp.features.scrolling.items.ScrollingItem
import kotlinx.coroutines.flow.Flow

interface ScrollingRepository {
    fun getPosts(): Flow<List<ScrollingItem>>
}