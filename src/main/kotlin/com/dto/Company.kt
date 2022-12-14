package com.dto

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Company (val id: Int, val company: String, val city: String, val timezone: String)
