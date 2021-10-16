package com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.playlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spotify.data.model.PlaylistLibrary
import com.spotify.data.store.remote.api.repository.library_repository.PlaylistRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class PlaylistFragmentViewModel(private val playlistRepository: PlaylistRepository) : ViewModel() {
    val playListLibraryList = MutableLiveData<ArrayList<PlaylistLibrary>>()

    var job: Job? = null

    init {
        fetchPlaylistLibrary()
    }

    private fun fetchPlaylistLibrary() {
        job = viewModelScope.launch {
            val response = playlistRepository.fetchPlaylistShowMain()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    playListLibraryList.apply {
                        value = Response.success(response.body()).body()!!.playlistLibraryList
                    }
                } else {
                    //TODO
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}