package app.storytel.gorshkov.storytellapp.features.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import app.storytel.gorshkov.storytellapp.features.details.repository.CommentsRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import timber.log.Timber

class DetailsViewModel(
    postId: Int,
    commentsRepository: CommentsRepository
) : ViewModel() {
    private val loadDataLiveData = MutableLiveData(true)

    val commentsViewModel = loadDataLiveData.switchMap {
        commentsRepository.getComments(postId)
            .onStart {
                progressLiveData.postValue(true)
                errorLiveData.postValue(false)
            }
            .onCompletion { progressLiveData.postValue(false) }
            .catch { exception ->
                Timber.e(exception)
                errorLiveData.postValue(true)
            }
            .asLiveData()
    }

    val progressLiveData = MutableLiveData<Boolean>()
    val errorLiveData = MutableLiveData<Boolean>()

    fun onNetworkErrorClicked() {
        loadDataLiveData.value = true
    }
}