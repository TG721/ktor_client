package com.ibsu.ktor_client.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ibsu.ktor_client.data.remote.dto.Location
import com.ibsu.ktor_client.domain.repository.TheRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocationUseCase @Inject constructor(
    private val repository: TheRepository
) {
    suspend fun getLocation(): Location? {
        return repository.getLocation()
    }
}