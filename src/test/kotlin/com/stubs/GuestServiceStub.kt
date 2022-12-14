package com.stubs

import com.dto.Guest
import com.model.Database
import com.service.GuestService

class GuestServiceStub(
    private val database: Database = DatabaseStub()
): GuestService {
    override fun getAllGuests(): ArrayList<Guest> {
        return database.getAllGuests()
    }

    override fun getGuestById(id: Int): Guest {
        return database.getGuestById(id)
    }
}