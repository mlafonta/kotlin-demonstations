package com.stubs

import com.dto.Company
import com.model.Database
import com.service.CompanyService

class CompanyServiceStub (
    private val database: Database = DatabaseStub()
): CompanyService {

    override fun getAllCompanies(): ArrayList<Company> {
        return database.getAllCompanies()
    }

    override fun getCompanyById(id: Int): Company {
        return database.getCompanyById(id)
    }
}