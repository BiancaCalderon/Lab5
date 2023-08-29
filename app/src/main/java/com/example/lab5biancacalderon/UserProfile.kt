package com.example.lab5biancacalderon

data class UserProfile(
    val name: String,
    val profileImageResId: Int,
    val favoriteConcerts: List<Concert>

)