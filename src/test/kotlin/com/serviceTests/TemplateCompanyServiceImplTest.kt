package com.serviceTests

import com.stubs.DatabaseStub
import com.dto.Company
import com.dto.Guest
import com.dto.Reservation
import com.service.TemplateService
import com.service.TemplateServiceImpl
import org.junit.jupiter.api.Test

internal class TemplateCompanyServiceImplTest {

    private val templateService: TemplateService = TemplateServiceImpl(
        database = DatabaseStub()
    )

    @Test
    fun testFormatTemplate() {
        val company = Company(
            id = 1,
            company = "testCompany",
            city = "testCity",
            timezone = "US/Central"
        )

        val guest = Guest(
            id = 1,
            firstName = "testFirstName",
            lastName = "testLastName",
            reservation = Reservation(
                roomNumber = 1,
                startTimestamp = 1,
                endTimestamp = 2
            )
        )
        val templateText = "{company}, {city}, {firstName}, {lastName}, {roomNumber}, {salutation}"
        val expectedValue = "testCompany, testCity, testFirstName, testLastName, 1, Good Afternoon"
        val actualValue = templateService.formatTemplate(guest, company, templateText)
        assert(expectedValue ==  actualValue)
    }

    @Test
    fun addTemplateToDatabase() {

    }
}