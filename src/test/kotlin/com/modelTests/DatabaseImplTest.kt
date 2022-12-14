package com.modelTests

import com.dto.Guest
import com.dto.Reservation
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.model.Database
import com.model.DatabaseImpl
import org.junit.jupiter.api.Test

internal class DatabaseImplTest {

    private val database: Database = DatabaseImpl(
        mapper = jacksonObjectMapper(),
        guestFile = "./src/test/kotlin/com/stubs/GuestsStub.json",
        templateFile = "./src/test/kotlin/com/stubs/TemplatesStub.json",
        companyFile = "./src/test/kotlin/com/stubs/CompaniesStub.json"
    )

    @Test
    fun testGetAllGuests() {
       val expectedResult: ArrayList<Guest> = arrayListOf(
           Guest(
               id = 1,
               firstName = "Test 1",
               lastName = "Guest 1",
               reservation =  Reservation(
                   roomNumber = 1,
                   startTimestamp = 0,
                   endTimestamp = 1
               )
           ),
           Guest(
               id = 2,
               firstName = "Test 2",
               lastName = "Guest 2",
               reservation = Reservation (
                   roomNumber = 2,
                   startTimestamp = 0,
                   endTimestamp = 1
               )
           )
       )
       val actualResult = database.getAllGuests()
       assert(expectedResult == actualResult)
    }

    @Test
    fun getGuestById() {
        val expectedResult = Guest(
            id = 2,
            firstName = "Test 2",
            lastName = "Guest 2",
            reservation = Reservation (
                roomNumber = 2,
                startTimestamp = 0,
                endTimestamp = 1
            )
        )
        val actualResult = database.getGuestById(2)
        assert(expectedResult == actualResult)
    }

    @Test
    fun getAllCompanies() {
    }

    @Test
    fun getCompanyById() {
    }

    @Test
    fun getAllTemplates() {
    }

    @Test
    fun getTemplateById() {
    }

    @Test
    fun addTemplate() {
    }
}