package com.nivs.applicationairpoc.card_list

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


data class PartnersOffersData(
    @SerializedName("PartnersOffersData")
    val partnersOffersData: List<PartnersOffersDataItem?>? = null
) {
    @Serializable
    @Entity(tableName = "our_partners")
    data class PartnersOffersDataItem(

        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,

        @SerializedName("image")
        val image: String? = null,

        @SerializedName("partnerCode")
        val partnerCode: String? = null,

        @SerializedName("description")
        val description: String? = null,

        @SerializedName("title")
        val title: String? = null,

        @SerializedName("category")
        val category: String? = null,

        @SerializedName("bannerImage")
        val bannerImage: String? = null

    )
}