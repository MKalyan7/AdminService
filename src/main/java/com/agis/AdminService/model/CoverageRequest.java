package com.agis.AdminService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoverageRequest {

    private String coverageCode;
    private String coverageName;
    private String effectiveDate;
    private String endDate;
    private boolean status;

}
