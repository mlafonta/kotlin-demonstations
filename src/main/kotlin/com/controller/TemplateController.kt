package com.controller

import com.dto.PostShape
import com.dto.Template
import com.service.*
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/templates")
class TemplateController(
    private val templateService: TemplateService = TemplateServiceImpl(),
    private val companyService: CompanyService = CompanyServiceImpl(),
    private val guestService: GuestService = GuestServiceImpl()
    ) {

    @Get(uri="/")
    fun getAllTemplates(): ArrayList<Template> {
        return templateService.getAllTemplates()
    }

    @Get(uri="/{id}")
    fun getTemplateById(id:Int): Template {
        return templateService.getTemplateById(id)
    }


    @Post(uri="/", produces = [MediaType.TEXT_PLAIN])
    fun getFormattedTemplate(postBody: PostShape): String {
        val guest = guestService.getGuestById(postBody.guestId)
        val company = companyService.getCompanyById(postBody.companyId)
        val templateText: String = if (postBody.template is Int) {
            templateService.getTemplateById(postBody.template).text
        } else {
            templateService.addTemplateToDatabase(postBody.template)
        }
        return templateService.formatTemplate(guest, company, templateText)
    }
}