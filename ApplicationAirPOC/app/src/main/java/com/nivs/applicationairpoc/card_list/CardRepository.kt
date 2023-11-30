package com.nivs.applicationairpoc.card_list

class CardRepository {
    private val cardService = RetrofitInstance.cardService

    suspend fun getCards(): CardResponse {
        return cardService.getCards()
    }
}