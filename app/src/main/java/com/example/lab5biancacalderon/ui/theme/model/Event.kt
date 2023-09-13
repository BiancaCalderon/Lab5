package com.example.lab5biancacalderon.ui.theme.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Event(
    val id: String,
    val name: String,
    val availableSeats: Int,
    val imageResourceId: Int
)
