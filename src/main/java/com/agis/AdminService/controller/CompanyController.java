package com.agis.AdminService.controller;

import com.agis.AdminService.model.CompanyRequest;
import com.agis.AdminService.model.CompanyResponse;
import com.agis.AdminService.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/createCompany")
    public long createCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.createCompany(companyRequest);
    }

    @GetMapping("/getCompanyDetails")
    public List<CompanyResponse> getAllCompanyDetails() {
        List<CompanyResponse> companyResponseList = companyService.getCompaniesDetails();
        return companyResponseList;
    }

    @GetMapping("/getCompanyById/{id}")
    public ResponseEntity<CompanyResponse> getCompanyResponseById(@PathVariable("id") long companyId) {
        CompanyResponse companyResponse = companyService.getCompanyDetails(companyId);
        return new ResponseEntity<>(companyResponse, HttpStatus.OK);
    }







}
