package com.dto

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Template(val id: Int, val text: String,)