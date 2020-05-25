package app.storytel.gorshkov.storytellapp.features.scrolling

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import app.storytel.gorshkov.storytellapp.features.scrolling.repository.ScrollingRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import timber.log.Timber

class ScrollingViewModel(
    repository: ScrollingRepository
) : ViewModel() {
    private val loadDataLiveData = MutableLiveData(true)
    val postsLiveData =
        loadDataLiveData
            .switchMap {
                repository.getPosts()
                    .onStart {
                        progressLiveData.postValue(true)
                        errorLiveData.postValue(false)
                    }
                    .onCompletion { progressLiveData.postValue(false) }
                    .catch { exception ->
                        Timber.e(exception)
                        errorLiveData.postValue(true)
                    }.asLiveData()
            }

    val progressLiveData = MutableLiveData<Boolean>()
    val errorLiveData = MutableLiveData<Boolean>()

    fun onNetworkErrorClicked() {
        loadDataLiveData.value = true
    }
}