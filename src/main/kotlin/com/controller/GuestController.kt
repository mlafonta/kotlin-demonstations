package com.controller

import com.dto.Guest
import com.service.GuestService
import com.service.GuestServiceImpl
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/guests")
class GuestController(
    private val guestService: GuestService = GuestServiceImpl()
) {

    @Get(uri="/")
    fun getAllGuests(): ArrayList<Guest> {
        return guestService.getAllGuests()
    }

    @Get(uri="/{id}")
    fun getGuestById(id: Int): Guest {
        return guestService.getGuestById(id)
    }
}