package app.storytel.gorshkov.storytellapp.features.scrolling

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import app.storytel.gorshkov.storytellapp.features.scrolling.repository.ScrollingRepository

class ScrollingViewModel(
    repository: ScrollingRepository
): ViewModel() {
    val postsViewModel = repository.getPosts()
        .asLiveData()
}