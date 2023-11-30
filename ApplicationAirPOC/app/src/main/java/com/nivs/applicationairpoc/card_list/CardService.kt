package com.nivs.applicationairpoc.card_list

import retrofit2.http.GET

interface CardService {
    @GET("credit_cards")
    suspend fun getCards(): CardResponse
}