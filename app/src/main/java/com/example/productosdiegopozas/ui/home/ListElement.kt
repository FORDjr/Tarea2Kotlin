package com.example.productosdiegopozas.ui.home

import java.io.Serializable

data class ListElement(
    val color: String,
    val name: String,
    val desc: String,
    val status: String,
    val details: String
) : Serializable
