package com.stubs

import com.dto.Company
import com.dto.Guest
import com.dto.Reservation
import com.dto.Template
import com.model.Database
import kotlin.Exception

class DatabaseStub: Database {
    override fun getAllGuests(): ArrayList<Guest> {
        return arrayListOf(
            Guest(
                id = 1,
                firstName = "Test First Name 1",
                lastName = "Test Last Name 1",
                reservation = Reservation(
                    roomNumber = 1,
                    startTimestamp = 1,
                    endTimestamp = 2
                )
            ),
            Guest(
                id = 2,
                firstName = "Test First Name 2",
                lastName = "Test Last Name 2",
                reservation = Reservation(
                    roomNumber = 2,
                    startTimestamp = 1,
                    endTimestamp = 2
                )
            )
        )
    }

    override fun getGuestById(id: Int): Guest {
        return getAllGuests().find { it.id == id } ?: throw Exception("Guest Not Found")
    }

    override fun getAllCompanies(): ArrayList<Company> {
        return arrayListOf(
            Company(
                id = 1,
                company = "Test Company 1",
                city = "Test City 1",
                timezone = "\"US/Central\""
            ),

            Company(
                id = 2,
                company = "Test Company 2",
                city = "Test City 2",
                timezone = "\"US/Central\""
            ),
        )
    }

    override fun getCompanyById(id: Int): Company {
        return getAllCompanies().find { it.id == id } ?: throw Exception("Company Not Found")
    }

    override fun getAllTemplates(): ArrayList<Template> {
        return arrayListOf(
            Template(
                id = 1,
                text = "Test 1"
            ),
            Template(
                id = 2,
                text = "Test 2"
            )
        )
    }

    override fun getTemplateById(id: Int): Template {
        return getAllTemplates().find { it.id == id } ?: throw Exception("Template Not Found")
    }

    override fun addTemplate(template: Template) {
        //no return
    }

}