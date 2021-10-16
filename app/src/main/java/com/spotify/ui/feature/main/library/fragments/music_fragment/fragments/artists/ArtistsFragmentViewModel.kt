package com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.artists

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spotify.data.model.ArtistsLibrary
import com.spotify.data.store.remote.api.repository.library_repository.ArtistsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class ArtistsFragmentViewModel(private val artistsRepository: ArtistsRepository) : ViewModel() {
    val artistLibraryList = MutableLiveData<ArrayList<ArtistsLibrary>>()

    var job: Job? = null

    init {
        fetchArtistLibrary()
    }

    private fun fetchArtistLibrary() {
        job = viewModelScope.launch {
            val response = artistsRepository.fetchLibraryArtistShowMain()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    artistLibraryList.apply {
                        value = Response.success(response.body()).body()!!.artistsLibraryList
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