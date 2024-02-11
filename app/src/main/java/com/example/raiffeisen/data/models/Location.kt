package com.example.raiffeisen.data.models

data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: Any?,
    val coordinates: Coordinates,
    val timezone: Timezone,
)