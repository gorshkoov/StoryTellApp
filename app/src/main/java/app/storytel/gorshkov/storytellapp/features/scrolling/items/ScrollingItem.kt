package app.storytel.gorshkov.storytellapp.features.scrolling.items

data class ScrollingItem(
    val id: Int,
    val title: String,
    val body: String,
    val fullImageUrl: String?,
    val thumbnailUrl: String?
)