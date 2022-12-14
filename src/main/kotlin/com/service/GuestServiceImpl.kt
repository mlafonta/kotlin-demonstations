package com.service

import com.dto.Guest
import com.model.Database
import com.model.DatabaseImpl

class GuestServiceImpl(
    private val database: Database = DatabaseImpl()
) : GuestService {

    override fun getAllGuests(): ArrayList<Guest> {
        return database.getAllGuests()
    }

    override fun getGuestById(id: Int): Guest {
        return database.getGuestById(id)
    }
}