package com.ibsu.ktor_client.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val city: String,
    val country: String
)