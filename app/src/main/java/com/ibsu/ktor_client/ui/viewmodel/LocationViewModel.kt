package com.ibsu.ktor_client.ui.viewmodel

import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibsu.ktor_client.data.remote.dto.Location
import com.ibsu.ktor_client.domain.usecase.GetLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(private val getLocationUseCase: GetLocationUseCase) : ViewModel(){

    private val _locationLiveData = MutableLiveData<Location?>()
    val locationLiveData: LiveData<Location?> get() = _locationLiveData

    fun getLocation() {
        viewModelScope.launch {
            val locationResult = getLocationUseCase.getLocation()

            // Handle null or error response here
            if (locationResult != null) {
                _locationLiveData.value = locationResult
            } else {
                // Handle the error or null case as per your application's logic.
                // For now, just setting null to LiveData.
                _locationLiveData.value = null
            }
            d("aaa",locationResult.toString())
        }
    }

}