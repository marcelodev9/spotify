package com.spotify.ui.feature.main.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spotify.data.model.CategoryMain
import com.spotify.data.store.remote.api.repository.search_repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class SearchViewModel(private val searchRepository: SearchRepository) : ViewModel() {

    val categoryMainList = MutableLiveData<ArrayList<CategoryMain>>()

    var job: Job? = null

    init {
        fetchCategoryList()
    }

    private fun fetchCategoryList() {
        job = viewModelScope.launch {
            val response = searchRepository.fetchSearchCategory()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    categoryMainList.apply {
                        value =
                            Response.success(response.body()).body()!!.categoryMainList
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