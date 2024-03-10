package com.agis.AdminService.service;

import com.agis.AdminService.model.CompanyRequest;
import com.agis.AdminService.model.CompanyResponse;

import java.util.List;

public interface CompanyService {
    long createCompany(CompanyRequest companyRequest);

    List<CompanyResponse> getCompaniesDetails();

    CompanyResponse getCompanyDetails(long companyId);
}
