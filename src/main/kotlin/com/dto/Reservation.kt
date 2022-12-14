package com.dto

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Reservation (val roomNumber: Int, val startTimestamp: Int, val endTimestamp: Int)
