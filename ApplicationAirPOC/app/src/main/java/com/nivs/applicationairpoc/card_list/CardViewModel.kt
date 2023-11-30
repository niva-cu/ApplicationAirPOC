package com.nivs.applicationairpoc.card_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CardViewModel : ViewModel() {
    private val repository = CardRepository()

    private val cards = MutableLiveData<CardResponse>()
    val availableCards: LiveData<CardResponse> = cards

    fun fetchCards() {
        viewModelScope.launch {
            try {
                val mCards = repository.getCards()
                cards.value = mCards
                Log.d("FetchCreditCard", cards.value.toString());
            } catch (e: Exception) {
                Log.e("FetchCreditCard", e.message.toString());
            }
        }
    }
}