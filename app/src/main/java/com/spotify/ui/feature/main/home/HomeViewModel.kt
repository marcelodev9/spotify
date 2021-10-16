package com.spotify.ui.feature.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spotify.data.model.Band
import com.spotify.data.model.BandShow
import com.spotify.data.store.remote.api.repository.home_repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {
    val bandMainList = MutableLiveData<ArrayList<Band>>()
    val bandShowMainList = MutableLiveData<ArrayList<BandShow>>()

    var job: Job? = null

    init {
        fetchBandShowMain()
    }

    private fun fetchBandShowMain() {
        job = viewModelScope.launch {
            val response = homeRepository.fetchBandShowMain()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    bandMainList.apply {
                        value = Response.success(response.body()).body()!!.bandList
                    }
                    bandShowMainList.apply {
                        value = Response.success(response.body()).body()!!.bandShowMainList
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