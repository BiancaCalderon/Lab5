package com.example.lab5biancacalderon

import com.example.lab5biancacalderon.R

data class Concert(
    val title: String,
    val subtitle: String,
    val imageResId: Int,
    val date: String,
    val description: String,
    val locations: List<String>,
    val isFavorite: Boolean
)