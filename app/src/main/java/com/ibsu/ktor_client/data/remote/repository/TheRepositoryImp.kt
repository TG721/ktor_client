package com.ibsu.ktor_client.data.remote.repository

import android.util.Log.d
import com.ibsu.ktor_client.data.remote.HttpRoutes
import com.ibsu.ktor_client.data.remote.dto.Location
import com.ibsu.ktor_client.domain.repository.TheRepository
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.get
import javax.inject.Inject

class TheRepositoryImp @Inject constructor(private val client: HttpClient) : TheRepository {

    override suspend fun getLocation(): Location? {
        return try {
            d("bb", "bbbb")
            client.get(HttpRoutes.LOCATION) {
            }
        } catch (e: RedirectResponseException) {
            //3xx - responses
            d("cdc", "cc1")
            println("Error ${e.response.status.description}")
            null
        } catch (e: ClientRequestException) {
            //4xx responses
            d("cdc", "cc2")
            d("cdc", e.response.status.description)
            println("Error ${e.response.status.description}")
            null
        } catch (e: ServerResponseException) {
            //5xx responses
            d("cdc", "cc3")
            println("Error ${e.response.status.description}")
            null
        } catch (e: Exception) {
            d("cdc", "cc4")
            println("Error ${e.message}")
            null
        }
    }

}