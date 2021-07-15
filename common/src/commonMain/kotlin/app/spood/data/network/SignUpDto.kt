package app.spood.data.network

import com.google.gson.annotations.SerializedName

data class SignUpDto(
    @SerializedName("email")
    val fullName: String,
    @SerializedName("password")
    val phoneNumber: String
)