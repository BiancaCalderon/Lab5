package com.example.lab6fnl.ui.theme.concert

data class Concert(
    val title: String,
    val subtitle: String,
    val imageResId: Int,
    val date: String,
    val description: String,
    val locations: List<String>,
    val isFavorite: Boolean
)