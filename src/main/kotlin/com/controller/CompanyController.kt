package com.controller

import com.dto.Company
import com.service.CompanyService
import com.service.CompanyServiceImpl
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/companies")
class CompanyController(
    private val companyService: CompanyService = CompanyServiceImpl()
) {

    @Get(uri="/")
    fun getAllCompanies(): ArrayList<Company> {
        return companyService.getAllCompanies()
    }

    @Get(uri="/{id}")
    fun getCompanyById(id: Int): Company {
        return companyService.getCompanyById(id)
    }
}