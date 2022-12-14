package com.service

import com.dto.Guest

interface GuestService {
    fun getAllGuests(): ArrayList<Guest>
    fun getGuestById(id: Int): Guest
}