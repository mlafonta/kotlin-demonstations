package com.dto

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Guest(val id: Int, val firstName: String, val lastName: String, val reservation: Reservation)
