package app.spood.common.data.network

import com.google.gson.annotations.SerializedName

data class TokenDto(
    @SerializedName("token")
    val token: String
)