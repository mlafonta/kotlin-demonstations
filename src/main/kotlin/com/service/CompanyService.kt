package com.service

import com.dto.Company

interface CompanyService {

    fun getAllCompanies(): ArrayList<Company>
    fun getCompanyById(id: Int): Company

}
