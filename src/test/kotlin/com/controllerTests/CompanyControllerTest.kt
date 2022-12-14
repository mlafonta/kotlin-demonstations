package com.controllerTests

import com.stubs.CompanyServiceStub
import com.controller.CompanyController
import com.dto.Company
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
internal class CompanyControllerTest(
) {

    private val companyController: CompanyController =
        CompanyController(
            companyService = CompanyServiceStub()
        )


    @Test
    fun testGetAllCompanies() {
        val expectedResult = arrayListOf(
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
        val actualResult = companyController.getAllCompanies()
        assert(expectedResult == actualResult)
    }

    @Test
    fun testGetCompanyById() {
        val expectedResult = Company(
            id = 2,
            company = "Test Company 2",
            city = "Test City 2",
            timezone = "\"US/Central\""
        )

        val actualResult = companyController.getCompanyById(2)
        assert(expectedResult == actualResult)
    }
}
