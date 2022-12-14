package com.service

import com.dto.Company
import com.dto.Guest
import com.dto.Template

interface TemplateService {

    fun formatTemplate(guest: Guest, company: Company, templateText: String): String
    fun getAllTemplates(): ArrayList<Template>
    fun getTemplateById(id: Int): Template
    fun addTemplateToDatabase(templateText: Any): String
}
