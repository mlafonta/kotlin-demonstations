package com.model

import com.dto.Company
import com.dto.Guest
import com.dto.Template

interface Database {
    fun getAllGuests(): ArrayList<Guest>
    fun getGuestById(id: Int): Guest
    fun getAllCompanies(): ArrayList<Company>
    fun getCompanyById(id: Int): Company
    fun getAllTemplates(): ArrayList<Template>
    fun getTemplateById(id: Int): Template
    fun addTemplate(template: Template)
}