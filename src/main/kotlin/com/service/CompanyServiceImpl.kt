package com.service

import com.dto.Company
import com.model.Database
import com.model.DatabaseImpl

class CompanyServiceImpl(
    private val database: Database = DatabaseImpl()
): CompanyService
{

    override fun getAllCompanies(): ArrayList<Company> {
        return database.getAllCompanies()
    }

    override fun getCompanyById(id: Int): Company {
        return database.getCompanyById(id)
    }
}