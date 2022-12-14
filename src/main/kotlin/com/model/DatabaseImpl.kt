package com.model

import com.dto.Company
import com.dto.Guest
import com.dto.Template
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

class DatabaseImpl(
    private val mapper: ObjectMapper = jacksonObjectMapper(),
    guestFile: String = "./src/main/Assets/Guests.json",
    companyFile: String = "./src/main/Assets/Companies.json",
    private val templateFile: String = "./src/main/Assets/Templates.json"
) : Database {

    private val guestListAsString: String = File(guestFile).readText(Charsets.UTF_8)
    private val guestList: ArrayList<Guest> =
        if (guestListAsString.isNotEmpty()) {
            mapper.readValue(guestListAsString)
        } else {
            ArrayList()
        }

    private val companyListAsString: String = File(companyFile).readText(Charsets.UTF_8)
    private val companyList: ArrayList<Company> =
        if (companyListAsString.isNotEmpty()) {
            mapper.readValue(companyListAsString)
        } else {
            ArrayList()
        }

    private val templateListAsString: String = File(templateFile).readText(Charsets.UTF_8)
    private val templateList: ArrayList<Template> =
        if (templateListAsString.isNotEmpty()) {
            mapper.readValue(templateListAsString)
        } else {
            ArrayList()
        }



    override fun getAllGuests(): ArrayList<Guest> {
        return guestList
    }

    override fun getGuestById(id: Int): Guest {
        return guestList.find { it.id == id } ?: throw Exception("No Guest Found")
    }

    override fun getAllCompanies(): ArrayList<Company> {
        return companyList
    }

    override fun getCompanyById(id: Int): Company {
        return companyList.find { it.id == id } ?: throw Exception("No Company Found")
    }

    override fun getAllTemplates(): ArrayList<Template> {
        return templateList
    }

    override fun getTemplateById(id: Int): Template {
        return templateList.find { it.id == id } ?: throw Exception("No Template Found")
    }


    override fun addTemplate(template: Template) {
        templateList.add(template)
        File(templateFile).writeText(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(templateList))
    }
}