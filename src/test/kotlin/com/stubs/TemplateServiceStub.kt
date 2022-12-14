package com.stubs

import com.dto.Company
import com.dto.Guest
import com.dto.Template
import com.model.Database
import com.service.TemplateService

class TemplateServiceStub(
    private val database: Database = DatabaseStub()
): TemplateService {
    override fun formatTemplate(guest: Guest, company: Company, templateText: String): String {
        return "true"
    }

    override fun getAllTemplates(): ArrayList<Template> {
        return database.getAllTemplates()
    }

    override fun getTemplateById(id: Int): Template {
        return database.getTemplateById(id)
    }

    override fun addTemplateToDatabase(templateText: Any): String {
        return "true"
    }
}