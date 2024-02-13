package com.example.randomuser.data.models.user

data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: Any?,
    val coordinates: Coordinates,
    val timezone: Timezone,
)