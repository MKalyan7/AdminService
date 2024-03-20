package com.agis.AdminService.service;

import com.agis.AdminService.entity.Coverage;
import com.agis.AdminService.model.CoverageRequest;
import com.agis.AdminService.repository.CoverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CoverageServiceImpl implements CoverageService{

    @Autowired
    private CoverageRepository coverageRepository;


    @Override
    public long createNewCoverage(CoverageRequest coverageRequest) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDate date = LocalDate.parse("29-Mar-2019", formatter);

        Coverage coverage = Coverage.builder()
                .coverageCode(coverageRequest.getCoverageCode())
                .coverageName(coverageRequest.getCoverageName())
                .effectiveDate(LocalDate.parse(coverageRequest.getEffectiveDate(),formatter))
                .endDate(LocalDate.parse(coverageRequest.getEndDate(),formatter)).build();
        coverage.setCreatedBy("ADMIN");
        coverage.setCreatedDate(Instant.now());
        coverageRepository.save(coverage);
        return coverage.getCoverageId();
    }
}
