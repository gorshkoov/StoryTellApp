package app.storytel.gorshkov.storytellapp.mapper

import app.storytel.gorshkov.storytellapp.features.scrolling.items.ScrollingItem
import app.storytel.gorshkov.storytellapp.network.response.PostResponse

fun PostResponse.mapToScrollingItem(): ScrollingItem = ScrollingItem(id, title, body)