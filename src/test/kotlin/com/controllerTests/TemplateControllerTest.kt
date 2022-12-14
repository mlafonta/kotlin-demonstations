package com.controllerTests

import com.stubs.CompanyServiceStub
import com.stubs.GuestServiceStub
import com.stubs.TemplateServiceStub
import com.controller.TemplateController
import com.dto.PostShape
import com.dto.Template
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
internal class TemplateControllerTest() {

    private val templateController: TemplateController = TemplateController(
        templateService = TemplateServiceStub(),
        guestService = GuestServiceStub(),
        companyService = CompanyServiceStub()
    )
    @Test
    fun testGetAllTemplates() {
        val expectedResult = arrayListOf(
            Template(
                id = 1,
                text = "Test 1"
            ),
            Template(
                id = 2,
                text = "Test 2"
            )
        )

        val actualResult = templateController.getAllTemplates()
        assert(expectedResult ==  actualResult)
    }

    @Test
    fun testGetTemplateById() {
        val expectedResult = Template(
            id = 1,
            text = "Test 1"
        )

        val actualResult = templateController.getTemplateById(1)
        assert(expectedResult == actualResult)
    }

    @Test
    fun testGetFormattedTemplateWithExistingTemplate() {

        val expectedResult = "true"
        val actualResult = templateController.getFormattedTemplate(PostShape(1, 1, 1))
        assert(expectedResult == actualResult)
    }

    @Test
    fun testGetFormattedTemplateWithNewTemplate() {

        val expectedResult = "true"
        val actualResult = templateController.getFormattedTemplate(PostShape(1, 1, "test"))
        assert(expectedResult == actualResult)
    }
}
