package org.kenuki.services

import io.ktor.client.*

object HttpClientService {
    private val httpClient = HttpClient()
    fun getClient() = httpClient
}