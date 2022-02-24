package com.example.rickmortyhiltmvvm.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmortyhiltmvvm.model.ResultApi
import com.example.rickmortyhiltmvvm.repository.RepositoryCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository : RepositoryCharacter)
    :ViewModel(){

    private val _response = MutableLiveData<List<ResultApi>>()

    val responseImage: LiveData<List<ResultApi>>
    get() = _response

    init {
        getAllImage()
    }

    private fun getAllImage() = viewModelScope.launch {
        repository.getAllImage().let { response ->
            if (response.isSuccessful){
                _response.postValue(response.body()?.results)
            }else{
                Log.d("your tag",
                    "getAllImages Error: ${response.errorBody()}")
            }
        }
    }


}