package com.service

import com.dto.Company
import com.dto.Guest
import com.dto.Template
import com.model.Database
import com.model.DatabaseImpl
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

class TemplateServiceImpl(
    private val database: Database = DatabaseImpl()
): TemplateService {

    override fun getAllTemplates(): ArrayList<Template> {
        return database.getAllTemplates()
    }

    override fun getTemplateById(id: Int): Template {
        return database.getTemplateById(id)
    }

    override fun formatTemplate(guest: Guest, company: Company, templateText: String): String {
        var mutableTemplateText = templateText
        mutableTemplateText = mutableTemplateText.replace("{company}", company.company)
        mutableTemplateText = mutableTemplateText.replace("{city}", company.city)
        mutableTemplateText = mutableTemplateText.replace("{firstName}", guest.firstName)
        mutableTemplateText = mutableTemplateText.replace("{lastName}", guest.lastName)
        mutableTemplateText = mutableTemplateText.replace("{roomNumber}", guest.reservation.roomNumber.toString())
        mutableTemplateText = mutableTemplateText.replace("{salutation}", chooseSalutation(company.timezone, guest.reservation.startTimestamp) )
        return mutableTemplateText
    }

    override fun addTemplateToDatabase(templateText: Any): String {
        val template: Template = if(getAllTemplates().isNotEmpty()){
                Template(
                    id = getAllTemplates().maxOf { it.id } + 1,
                    text = templateText.toString()
                )
            } else {
                Template(
                    id = 1,
                    text = templateText.toString()
                )
            }
        database.addTemplate(template)

        return templateText.toString()
    }

    private fun chooseSalutation(timezone: String, startTimestamp: Int): String {
        val zone = ZoneId.of(timezone)
        val date = ZonedDateTime.ofInstant( Instant.ofEpochSecond(startTimestamp.toLong()), zone)
        return when (date.hour) {
            in 4..12 -> {
                "Good Morning"
            }
            in 12..18 -> {
                "Good Afternoon"
            }
            else -> {
                "Good Evening"
            }
        }
    }
}
