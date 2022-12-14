package com.dto

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class PostShape(val companyId: Int, val guestId: Int, val template: Any,)
