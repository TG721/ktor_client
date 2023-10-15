package com.ibsu.ktor_client.domain.repository

import com.ibsu.ktor_client.data.remote.dto.Location

interface TheRepository {

    suspend fun getLocation(): Location?

}