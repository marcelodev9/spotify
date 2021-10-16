package com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.album

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spotify.data.model.AlbumLibrary
import com.spotify.data.store.remote.api.repository.library_repository.AlbumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class AlbumsFragmentViewModel(private val albumRepository: AlbumRepository) : ViewModel() {
    val albumLibraryList = MutableLiveData<ArrayList<AlbumLibrary>>()

    var job: Job? = null

    init {
        fetchAlbumLibrary()
    }

    private fun fetchAlbumLibrary() {
        job = viewModelScope.launch {
            val response = albumRepository.fetchLibraryAlbumShowMain()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    albumLibraryList.apply {
                        value = Response.success(response.body()).body()!!.albumLibraryList
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