package com.agis.AdminService.controller;

import com.agis.AdminService.model.CoverageRequest;
import com.agis.AdminService.service.CoverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/coverage")
public class CoverageController {

    @Autowired
    CoverageService coverageService;

    @PostMapping("/createNewCoverage")
    public long  createNewCoverage(@RequestBody CoverageRequest coverageRequest) {
        return coverageService.createNewCoverage(coverageRequest);
    }



}
