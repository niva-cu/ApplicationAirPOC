package com.nivs.applicationairpoc.card_list

data class CardResponse(
    val id: Int,
    val uid: String,
    val credit_card_number: String,
    val credit_card_expiry_date: String,
    val credit_card_type: String
)